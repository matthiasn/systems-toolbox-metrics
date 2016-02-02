(ns matthiasn.systems-toolbox-metrics.metrics
  (:gen-class)
  (:import [java.lang.management ManagementFactory
                                 OperatingSystemMXBean
                                 MemoryMXBean
                                 MemoryUsage
                                 GarbageCollectorMXBean
                                 RuntimeMXBean]))

(def ^OperatingSystemMXBean os-mx-bean (ManagementFactory/getOperatingSystemMXBean))
(def ^MemoryMXBean mem-mx-bean (ManagementFactory/getMemoryMXBean))
(def ^GarbageCollectorMXBean gc-mx-bean (first (ManagementFactory/getGarbageCollectorMXBeans)))
(def ^RuntimeMXBean rt-mx-bean (ManagementFactory/getRuntimeMXBean))

(defn system-utilization
  []
  (let [^MemoryUsage mem-usage (.getHeapMemoryUsage mem-mx-bean)]
    {:system-load-avg (.getSystemLoadAverage os-mx-bean)
     :available-cpus  (.getAvailableProcessors os-mx-bean)
     :heap-used       (.getUsed mem-usage)
     :heap-max        (.getMax mem-usage)
     :gc-count        (.getCollectionCount gc-mx-bean)
     :gc-time         (.getCollectionTime gc-mx-bean)
     :uptime          (.getUptime rt-mx-bean)
     :start-time      (.getStartTime rt-mx-bean)}))

(defn send-stats
  [{:keys [put-fn msg-meta]}]
  (put-fn (with-meta [:stats/jvm (system-utilization)] msg-meta)))

(defn cmp-map
  {:added "0.3.1"}
  [cmp-id]
  {:cmp-id      cmp-id
   :handler-map {:cmd/get-jvm-stats send-stats}})

