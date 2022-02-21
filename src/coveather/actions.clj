(ns coveather.actions)

;;; An Action Record
(defrecord Action [type ;; :certify :propose :remove
                   timestamp ;; time in unix
                   expires ;; time in unix that action expires
                   body ;; body of action
                   payload]) ;; payload for any things
                          

                   
