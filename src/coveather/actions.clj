(ns coveather.actions)

;;; An Action Record
(defrecord Action [type ;; :certify :propose :remove
                   timestamp ;; time in unix
                   expiry ;; number of seconds from timestamp
                   body ;; body of action
                   payload]) ;; payload for any things
                          

                   
