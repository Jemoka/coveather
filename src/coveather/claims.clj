(ns coveather.claims
  (:require [coveather.data.claims :as claims-data]
            [coveather.tickets :refer [Ticket stamp staple]]
            [coveather.utils :as utils]
            [coveather.actions :refer [->Action
                                       map->Action]]))

;;; Ticketing Claims
;; Helper function to unwrap a claim
(defn unwrap-claim
  "Unwrap a string claim ID to its dependencies, items to be verified, min expiration date"
  
  [id claims]

  (let [claim (first (filter #(= id (:id %)) claims))
        subclaims (map #(unwrap-claim % claims) (:inherits claim))]

    {:identities (distinct (concat (:identities claim)
                                   (apply concat
                                          (map #(:identities %) subclaims))))
     :expiry (let [subclaim-min (apply min (cons
                                            Integer/MAX_VALUE
                                            (map #(:expiry %) subclaims)))]
               (if (> (:expiry claim) 0)
                 (min (:expiry claim) subclaim-min)
                 subclaim-min))
     :claims (dedupe (cons (dissoc claim
                                   :identities
                                   :inherits
                                   :expiry)
                           (apply concat
                                  (map #(:claims %) subclaims))))}))

;; Ticket requesting the claim be verified
(defrecord ClaimVerificationTicket [claim artifacts]
  Ticket

  (stamp
    [this state]
    (let [fullclaim (unwrap-claim (:claim this)
                                  (:claims state))
          timestamp (quot (System/currentTimeMillis) 1000)]
      (map->Action {:type :verify
                    :timestamp timestamp
                    :expires (+ (:expiry fullclaim) timestamp)
                    :body (:claims fullclaim)
                    :payload (:artifacts this)})))

  (staple [this state verification] verification))

(stamp (ClaimVerificationTicket. "status.testing.covid19.0.3" nil)
       (utils/map->State {:claims claims-data/test-claims}))






;; Ticket requesting a new claim be proposed
;; (defrecord ClaimProposalTicket [claim]
;;   Ticket

;;   (stamp
;;     "Stamp the ticket"

;;     [this artifacts]))
  


;;; Generate a claim in claim syntax
(defmacro claim
  "Helper macro to create a claim in the claim syntax"

  [id name expiry &{:keys [inherits identities]}]
  `{:type :claim
    :id ~id
    :name ~name
    :expiry ~expiry
    :identities ~identities
    :inherits ~inherits})

