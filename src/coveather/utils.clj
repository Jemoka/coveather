(ns coveather.utils
  (:import [java.util Base64]
           [java.security MessageDigest])
  (:require [clj-pgp
             [core :as pgp]
             keyring
             [message :as msg]]))

;;; Blockchain Info Utilties
(defrecord State [tickets agents verifiers
                  claims identities])

;;; File Encoding Utilities
(defn encode-file 
  "Encode a file to its base64 representation"

  [path]
  (String. (.encode
            (java.util.Base64/getEncoder)
            (.getBytes
             (slurp path)))))

(defn decode-file
  "Decode a base64 representation string to file"

  [encoded path]
  (let [decoded (String. (.decode (Base64/getDecoder)
                                  encoded))]
    (spit path decoded)
    decoded))


;;; Randomness
(defn random-predictable
  "Generates a predictably random list of length n via initial-state"

  [n initial-state]
  (loop [state initial-state
         rng (java.util.Random. state)
         series []]
    (if (< (count series) n)
      (let [i (.nextInt rng)]
        (recur i
               (java.util.Random. i)
               (cons i series)))
      series)))


;;; Security Utilities
(defn sha-hash
  "SHA-256 a la https://gist.github.com/kubek2k/8446062"
  [obj]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes (str obj) "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

(defn encrypt
  "Encrypt string data via a public key path"

  [msg key-path]
  (let [key (first (pgp/decode (slurp key-path)))]
    (msg/encrypt msg key)))
                 ;; :format :utf8
                 ;; :armor true)))

(defn decrypt
  "Decrypt string data via a private key path"

  [msg key-path]
  (let [key (first (pgp/decode (slurp key-path)))]
    (msg/decrypt msg key)))

(let [key (first (pgp/decode (slurp "./resources/keys/id_rsa")))]
  (msg/decrypt msg key))


(msg/decrypt (encrypt "hello" "./resources/keys/id_rsa.pub")
             (first (pgp/decode (slurp "./resources/keys/id_rsa")))
             :format :utf8
             :armor true)

(pgp/key-info
 (first ))


(let [message (encrypt "hello" "./resources/keys/id_rsa.pub")
      key (first (pgp/decode (slurp "./resources/keys/id_rsa")))]
  (msg/decrypt message key))

(pgp/key-info
 (first
  (pgp/decode (slurp "./resources/keys/id_rsa"))))

(first
  (pgp/decode (slurp "./resources/keys/id_rsa")))





