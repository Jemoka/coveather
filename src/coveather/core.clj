(ns coveather.core
  (:import (org.zeromq ZMQ
                       ZContext
                       SocketType))
  (:gen-class))

(let [context (new ZContext)
      push-socket (.createSocket context SocketType/PUSH)]

  (.bind push-socket "tcp://*:5051")
  (.close push-socket))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

