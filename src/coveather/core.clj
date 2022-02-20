(ns coveather.core
  (:import (org.zeromq ZMQ))
  (:gen-class))


(ZMQ/context 0)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

