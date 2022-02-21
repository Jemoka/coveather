(ns coveather.actions)

;;; An Action Record
(defrecord Action [timestamp
                   type
                   artifacts])
