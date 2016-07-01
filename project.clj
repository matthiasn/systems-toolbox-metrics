(defproject matthiasn/systems-toolbox-metrics "0.6.1-SNAPSHOT"
  :description "Basic JVM stats for systems-toolbox apps"
  :url "https://github.com/matthiasn/systems-toolbox"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs" "src/cljc"]

  :dependencies [[matthiasn/systems-toolbox-ui "0.6.1-SNAPSHOT"]]

  :plugins [[lein-codox "0.9.5" :exclusions [org.clojure/clojure]]
            [lein-cljsbuild "1.1.3"]])
