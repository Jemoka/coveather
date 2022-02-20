(ns coveather.data.claims)

(def test-claims
  '[{:type :claim
     :id "claims.vaccination.covid19.1"
     :name "COVID19 vaccine, fully vaccinated"
     :artifacts ["artifacts.vaccination.covid19.0"]
     :expiry 0},
    {:type :claim
     :id "claims.vaccination.covid19.2"
     :name "COVID19 vaccine, fully vaccinated and boosted"
     :artifacts ["artifacts.vaccination.covid19.0"]
     :expiry 0},
    {:type :claim
     :id "claims.testing.covid19.1"
     :name "COVID19 Test, Positive"
     :artifacts ["artifacts.testing.covid19.0"]
     :expiry 432000},
    {:type :claim
     :id "claims.testing.covid19.0"
     :name "COVID19 Test, Negative"
     :artifacts ["artifacts.testing.covid19.0"]
     :expiry 259200},
    {:type :claim
     :id "claims.vaccination.covid19.0.0"
     :name "COVID19 Vaccine, one shot as a part of 2-shot series"
     :expiry 0},
    {:type :claim
     :id "claims.vaccination.covid19.1.0"
     :name "COVID19 Vaccine, 2 shots as a part of 2-shot series"
     :inherits ["claims.vaccination.covid19.1"]
     :expiry 0},
    {:type :claim
     :id "claims.vaccination.covid19.1.1"
     :name "COVID19 Vaccine, 1 shot as a part of 1-shot series"
     :inherits ["claims.vaccination.covid19.1"]
     :expiry 0},
    {:type :claim
     :id "claims.vaccination.covid19.2.0"
     :name "COVID19 Vaccine, 2 shots as a part of 2-shot series, 1 shot as a part of booster series"
     :inherits ["claims.vaccination.covid19.2"]
     :expiry 0},
    {:type :claim
     :id "claims.vaccination.covid19.2.1"
     :name "COVID19 Vaccine, 1 shot as a part of 1-shot series, 1 shot as a part of booster series"
     :inherits ["claims.vaccination.covid19.2"]
     :expiry 0},
    {:type :claim
     :id "claims.testing.covid19.0.0"
     :name "COVID19 Test, RT-PCR Swab, Negative"
     :inherits ["claims.testing.covid19.0"]
     :expiry 259200},
    {:type :claim
     :id "claims.testing.covid19.1.0"
     :name "COVID19 Test, RT-PCR Swab, Positive"
     :inherits ["claims.testing.covid19.1"]
     :expiry 432000}
    {:type :claim
     :id "claims.testing.covid19.0.1"
     :name "COVID19 Test, LAMP-PCR Swab, Negative"
     :inherits ["claims.testing.covid19.0"]
     :expiry 259200},
    {:type :claim
     :id "claims.testing.covid19.1.1"
     :name "COVID19 Test, LAMP-PCR Swab, Positive"
     :inherits ["claims.testing.covid19.1"]
     :expiry 432000},
    {:type :claim
     :id "claims.testing.covid19.0.2"
     :name "COVID19 Test, Rapid Antigen Test, Negative"
     :inherits ["claims.testing.covid19.0"]
     :expiry 86400},
    {:type :claim
     :id "claims.testing.covid19.1.2"
     :name "COVID19 Test, Rapid Antigen Test, Positive"
     :inherits ["claims.testing.covid19.1"]
     :expiry 432000},
    {:type :claim
     :id "claims.testing.covid19.0.3"
     :name "COVID19 Test, IgM Antibody Test, Negative"
     :inherits ["claims.testing.covid19.0"]
     :expiry 259200},
    {:type :claim
     :id "claims.testing.covid19.1.3"
     :name "COVID19 Test, IgM Antibody Test, Positive"
     :inherits ["claims.testing.covid19.1"]
     :expiry 0}])
