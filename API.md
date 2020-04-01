Show All Users
----
  Fetching all users(Korisnici)

* **URL**

  </korisniks>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**

  {
  "_embedded" : {
    "korisniks" : [ {
      "firstName" : "Jack",
      "lastName" : "Bauer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/1"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/1"
        }
      }
    }, {
      "firstName" : "Chloe",
      "lastName" : "O'Brian",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/2"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/2"
        }
      }
    }, {
      "firstName" : "Kim",
      "lastName" : "Bauer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/3"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/3"
        }
      }
    }, {
      "firstName" : "David",
      "lastName" : "Palmer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/4"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/4"
        }
      }
    }, {
      "firstName" : "Michelle",
      "lastName" : "Dessler",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/5"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/5"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/korisniks"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/korisniks"
    },
    "search" : {
      "href" : "http://localhost:8080/korisniks/search"
    }
  }
}
 
* **Error Response:**
* **Sample Call:**
curl http://localhost:8080/korisniks
 {
  "_embedded" : {
    "korisniks" : [ {
      "firstName" : "Jack",
      "lastName" : "Bauer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/1"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/1"
        }
      }
    }, {
      "firstName" : "Chloe",
      "lastName" : "O'Brian",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/2"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/2"
        }
      }
    }, {
      "firstName" : "Kim",
      "lastName" : "Bauer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/3"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/3"
        }
      }
    }, {
      "firstName" : "David",
      "lastName" : "Palmer",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/4"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/4"
        }
      }
    }, {
      "firstName" : "Michelle",
      "lastName" : "Dessler",
      "location" : "Visoko",
      "birthDate" : null,
      "email" : "Iomanovic1@etf.unsa.ba",
      "phone" : "062/111-111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/korisniks/5"
        },
        "korisnik" : {
          "href" : "http://localhost:8080/korisniks/5"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/korisniks"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/korisniks"
    },
    "search" : {
      "href" : "http://localhost:8080/korisniks/search"
    }
  }
}
* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Show All Tenders
----
  Fetching all tenders(Ponude)

* **URL**

  </ponudas>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**


{
  "_embedded": {
    "ponudas": [
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/ponudas/1"
          },
          "ponuda": {
            "href": "http://localhost:8080/ponudas/1"
          }
        }
      },
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/ponudas/2"
          },
          "ponuda": {
            "href": "http://localhost:8080/ponudas/2"
          }
        }
      },
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/ponudas/3"
          },
          "ponuda": {
            "href": "http://localhost:8080/ponudas/3"
          }
        }
      },
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/ponudas/4"
          },
          "ponuda": {
            "href": "http://localhost:8080/ponudas/4"
          }
        }
      },
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/ponudas/5"
          },
          "ponuda": {
            "href": "http://localhost:8080/ponudas/5"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/ponudas"
    },
    "profile": {
      "href": "http://localhost:8080/profile/ponudas"
    },
    "search": {
      "href": "http://localhost:8080/ponudas/search"
    }
  }
}

* **Error Response:**
-ubaciti pogrešan odgovor

--------------------------------------------------------------------------------------------

Show All Katalogs
----
  Fetching all katalogs(Katalog)

* **URL**

  </katalog>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**

{
  "_embedded": {
    "katalog": []
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/katalog{?page,size,sort}",
      "templated": true
    },
    "profile": {
      "href": "http://localhost:8080/profile/katalog"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 0,
    "totalPages": 0,
    "number": 0
  }
}

* **Error Response:**
-ubaciti pogrešan odgovor

-------------------------------------------------------------------------------------------------

Update user
----
  Update user with id

* **URL**

  </korisniks/id>

* **Method:**

  `PUT` 

*  **URL Params**
 <id>
* **Data Params**
 <korisnik>

* **Success Response:**

 {
  "firstName": "Sijah",
  "lastName": "Amir",
  "location": "Travnik",
  "birthDate": null,
  "email": "asijah1@etf.unsa.ba",
  "phone": "062111222",
  "_links": {
    "self": {
      "href": "http://localhost:8080/korisniks/1"
    },
    "korisnik": {
      "href": "http://localhost:8080/korisniks/1"
    }
  }
}
 
* **Error Response:**
* **Sample Call:**
curl -X PUT -H "Content-Type: application/json" -d "{""id"":1,""lastName"":""Amir"",""location"":""Travnik"",""email"":""asijah1@etf.unsa.ba"",""phone"":""062111222""}"  "http://localhost:8080/korisniks/1"
{
  "firstName" : null,
  "lastName" : "Amir",
  "location" : "Travnik",
  "birthDate" : null,
  "email" : "asijah1@etf.unsa.ba",
  "phone" : "062111222",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/korisniks/1"
    },
    "korisnik" : {
      "href" : "http://localhost:8080/korisniks/1"
    }
  }
}
* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 

-------------------------------------------------------------------------------------------------

Update katalog
----
  Update katalog with id

* **URL**

  </katalogs/id>

* **Method:**

  `PUT` 

*  **URL Params**
 <id>
* **Data Params**
 <katalog>

* **Success Response:**

{
  "nazivProizvoda" : "auto",
  "dodatneInformacije" : "dodatneInformacije-Dodano",
  "cijena" : 3501,
  "datumObjave" : null,
  "datumZavrsetka" : null,
  "podkategorijaId" : 1,
  "korisnikId" : 2,
  "zavrseno" : false,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/katalogs/1"
    },
    "katalog" : {
      "href" : "http://localhost:8080/katalogs/1"
    }
  }
}
 
* **Error Response:**
* **Sample Call:**
curl -X PUT -H "Content-Type: application/json" -d "{""nazivProizvoda"":""auto"",""dodatneInformacije"":""dodatneInformacije-Dodano"",""cijena"":3501,""datumObjave"":null,""datumZavrsetka"":null,""podkategorijaId"":1,""korisnikId"":2,""zavrseno"": false}"  "http://localhost:8080/katalogs/1"
{
  "nazivProizvoda" : "auto",
  "dodatneInformacije" : "dodatneInformacije-Dodano",
  "cijena" : 3501,
  "datumObjave" : null,
  "datumZavrsetka" : null,
  "podkategorijaId" : 1,
  "korisnikId" : 2,
  "zavrseno" : false,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/katalogs/1"
    },
    "katalog" : {
      "href" : "http://localhost:8080/katalogs/1"
    }
  }
}
* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 

-------------------------------------------------------------------------------------------------

Update ponuda
----
  Update ponuda with id

* **URL**

  </ponudas/id>

* **Method:**

  `PUT` 

*  **URL Params**
 <id>
* **Data Params**
 <katalog>

* **Success Response:**

{
  "idKatalog" : 1,
  "idKorisnik" : 1,
  "ponuda" : 115,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/ponudas/1"
    },
    "ponuda" : {
      "href" : "http://localhost:8080/ponudas/1"
    }
  }
}
 
* **Error Response:**
* **Sample Call:**
curl -X PUT -H "Content-Type: application/json" -d "{""idKatalog"":1,""idKorisnik"":1,""ponuda"":115}"  "http://localhost:8080/ponudas/1"
{
  "idKatalog" : 1,
  "idKorisnik" : 1,
  "ponuda" : 115,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/ponudas/1"
    },
    "ponuda" : {
      "href" : "http://localhost:8080/ponudas/1"
    }
  }
}
* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 