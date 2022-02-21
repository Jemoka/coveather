(ns coveather.tickets)

;;; Ticket Protocol
(defprotocol Ticket

  ;; Stamp a ticket to be submitted for verification with
  ;; potential documentation. Usually this means timestamp
  ;; and other verification-required items.
  (stamp [this] [this artifacts]
    "Stamp the ticket with artifacts+time. Must return Action.")

  ;; Staple a ticket with the verification result (block number
  ;; etc.) so that it can independently be looked up and
  ;; submitted.
  (staple [this verification]
    "Staple the ticket with verification result to be distributed."))
  
