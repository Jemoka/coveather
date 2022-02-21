(ns coveather.utils
  (:import [java.util Base64]
           [java.security MessageDigest]))

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


;;; Randomness and Security Utilities
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

(defn sha-hash
  "SHA-256 a la https://gist.github.com/kubek2k/8446062"
  [obj]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes (str obj) "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

