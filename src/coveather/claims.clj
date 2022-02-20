(ns coveather.claims
  (:require [coveather.data.claims :as claims-data]))

;;; Ticketing Claims

;; (map->Test)

  


;;; Generate a claim in claim syntax
(defmacro claim
  "Helper macro to create a claim in the claim syntax"

  [id name expiry &{:keys [artifacts inherits]}]
  `{:type :claim
    :id ~id
    :name ~name
    :expiry ~expiry
    :artifacts ~artifacts
    :inherits ~inherits})

