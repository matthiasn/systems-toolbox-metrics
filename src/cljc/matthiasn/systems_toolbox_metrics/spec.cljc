(ns matthiasn.systems-toolbox-metrics.spec
  (:require
    #?(:clj  [clojure.spec :as s]
       :cljs [cljs.spec :as s])))

(s/def :cmd/mouse-pos
  (s/keys :req-un [:ex/x :ex/y]))

(s/def :stats/jvm
  (s/keys :req-un [:stats/system-load-avg
                   :stats/available-cpus
                   :stats/heap-used
                   :stats/heap-max
                   :stats/gc-count
                   :stats/gc-time
                   :stats/uptime
                   :stats/start-time]))
