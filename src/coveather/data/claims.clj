(ns coveather.data.claims)

(def test-claims
  '[{:type :artifact
     :id "artifact.vaccination.covid19.0"
     :name "COVID19 vaccine record card, United States"
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :playload true
     :expiry 0}
    {:type :artifact
     :id "artifact.testing.covid19.0"
     :name "COVID19 test lab report"
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :playload true
     :expiry 604800},
    {:type :status
     :id "status.vaccination.covid19.1"
     :name "COVID19 vaccine, fully vaccinated"
     :inherits ["artifacts.vaccination.covid19.0"]
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :expiry 0},
    {:type :status
     :id "status.vaccination.covid19.2"
     :name "COVID19 vaccine, fully vaccinated and boosted"
     :inherits ["artifact.vaccination.covid19.0"]
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :expiry 0},
    {:type :status
     :id "status.testing.covid19.1"
     :name "COVID19 Test, Positive"
     :inherits ["artifact.testing.covid19.0"]
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :expiry 432000},
    {:type :status
     :id "status.testing.covid19.0"
     :name "COVID19 Test, Negative"
     :inherits ["artifact.testing.covid19.0"]
     :identities ["identities.personal.0.0", "identities.personal.0.1"]
     :expiry 259200},
    {:type :status
     :id "status.vaccination.covid19.0.0"
     :inherits ["artifact.vaccination.covid19.0"]
     :name "COVID19 Vaccine, one shot as a part of 2-shot series"
     :expiry 0},
    {:type :status
     :id "status.vaccination.covid19.1.0"
     :name "COVID19 Vaccine, 2 shots as a part of 2-shot series"
     :inherits ["status.vaccination.covid19.1"]
     :expiry 0},
    {:type :status
     :id "status.vaccination.covid19.1.1"
     :name "COVID19 Vaccine, 1 shot as a part of 1-shot series"
     :inherits ["status.vaccination.covid19.1"]
     :expiry 0},
    {:type :status
     :id "status.vaccination.covid19.2.0"
     :name "COVID19 Vaccine, 2 shots as a part of 2-shot series, 1 shot as a part of booster series"
     :inherits ["status.vaccination.covid19.2"]
     :expiry 0},
    {:type :status
     :id "status.vaccination.covid19.2.1"
     :name "COVID19 Vaccine, 1 shot as a part of 1-shot series, 1 shot as a part of booster series"
     :inherits ["status.vaccination.covid19.2"]
     :expiry 0},
    {:type :status
     :id "status.testing.covid19.0.0"
     :name "COVID19 Test, RT-PCR Swab, Negative"
     :inherits ["status.testing.covid19.0"]
     :expiry 259200},
    {:type :status
     :id "status.testing.covid19.1.0"
     :name "COVID19 Test, RT-PCR Swab, Positive"
     :inherits ["status.testing.covid19.1"]
     :expiry 432000}
    {:type :status
     :id "status.testing.covid19.0.1"
     :name "COVID19 Test, LAMP-PCR Swab, Negative"
     :inherits ["status.testing.covid19.0"]
     :expiry 259200},
    {:type :status
     :id "status.testing.covid19.1.1"
     :name "COVID19 Test, LAMP-PCR Swab, Positive"
     :inherits ["status.testing.covid19.1"]
     :expiry 432000},
    {:type :status
     :id "status.testing.covid19.0.2"
     :name "COVID19 Test, Rapid Antigen Test, Negative"
     :inherits ["status.testing.covid19.0"]
     :expiry 86400},
    {:type :status
     :id "status.testing.covid19.1.2"
     :name "COVID19 Test, Rapid Antigen Test, Positive"
     :inherits ["status.testing.covid19.1"]
     :expiry 432000},
    {:type :status
     :id "status.testing.covid19.0.3"
     :name "COVID19 Test, IgM Antibody Test, Negative"
     :inherits ["status.testing.covid19.0"]
     :expiry 259200},
    {:type :status
     :id "status.testing.covid19.1.3"
     :name "COVID19 Test, IgM Antibody Test, Positive"
     :inherits ["status.testing.covid19.1"]
     :expiry 0}])
