(ns coveather.claims
  (:require [coveather.data.claims :as claims-data]
            [coveather.tickets :refer [Ticket]]))

;;; Ticketing Claims
;; Helper function to unwrap a claim
(defn unwrap-claim
  "Unwrap a string claim ID to its dependencies, given a claim library"
  
  [id claims]

  (let [claim (first (filter #(= id (:id %)) claims))
        subclaims (map #(unwrap-claim % claims) (:inherits claim))]

    {:identities (distinct (concat (:identities claim)
                                   (apply concat
                                          (map #(:identities %) subclaims))))
     :claims (dedupe (cons (dissoc claim
                                   :identities
                                   :inherits)
                           (apply concat
                                  (map #(:claims %) subclaims))))}))



(unwrap-claim "status.testing.covid19.1.3" claims-data/test-claims)


;; Ticket requesting the claim be verified
(defrecord ClaimVerificationTicket [claim state]
  Ticket

  (stamp
    "Stamp the ticket with an artifact and time"

    [this artifacts]))

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

