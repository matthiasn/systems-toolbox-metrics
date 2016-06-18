(defproject matthiasn/systems-toolbox-metrics "0.6.1-SNAPSHOT"
  :description "Basic JVM stats for systems-toolbox apps"
  :url "https://github.com/matthiasn/systems-toolbox"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs" "src/cljc"]

  :dependencies [[org.clojure/clojure "1.9.0-alpha7"]
                 [org.clojure/clojurescript "1.9.76"]
                 [org.ow2.asm/asm-all "5.1"]
                 [org.clojure/core.async "0.2.385"]
                 [matthiasn/systems-toolbox-ui "0.6.1-SNAPSHOT"]
                 [com.lucasbradstreet/cljs-uuid-utils "1.0.2"]]

  :plugins [[lein-codox "0.9.5" :exclusions [org.clojure/clojure]]
            [lein-cljsbuild "1.1.3"]])
