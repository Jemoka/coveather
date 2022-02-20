(ns coveather.core
  (:require [coveather.action :as action])
  (:import [org.zeromq ZMQ
                       ZContext
                       SocketType])
  (:gen-class)



;; (let [context (new ZContext)
;;       push-socket (.createSocket context SocketType/PUSH)]

;;   (.bind push-socket "tcp://*:5051")
;;   (.close push-socket))





(random-predictable)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

