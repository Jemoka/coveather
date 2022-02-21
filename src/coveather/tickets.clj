(ns coveather.tickets)

;;; Ticket Protocol
(defprotocol Ticket

  ;; Generate a stub from the ticket to request someone's
  ;; verification. Its called "stub" because stubs can only
  ;; be used once and the ticket will be discarded. 
  (stub [this state]
    "Generate a stub from ticket. Must return Action.")
    
  ;; Stamp a ticket to be submitted for verification
  ;; with a stub and current state. Usually this means
  ;; timestamp and other verification-required items.
  (stamp [this state stub]
    "Stamp the ticket with time and state. Must return Action.")

  ;; Staple a ticket with the verification result (block number
  ;; etc.) so that it can independently be looked up and
  ;; submitted.
  (staple [this state verification]
    "Staple the ticket with verification result to be distributed."))
  
