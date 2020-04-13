Prikaže sve kataloge
----
  Dohvati sve kataloge

* **URL**

  </katalozi>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**
```json
  [
    {
        "id": 1,
        "nazivProizvoda": "mobitel",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 250,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 1,
        "korisnikId": 2,
        "zavrseno": true
    },
    {
        "id": 2,
        "nazivProizvoda": "auto",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 5500,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 3,
        "korisnikId": 4,
        "zavrseno": true
    },
    {
        "id": 3,
        "nazivProizvoda": "avion",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 1000000,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 5,
        "korisnikId": 6,
        "zavrseno": true
    },
    {
        "id": 4,
        "nazivProizvoda": "kamion",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 20000,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 7,
        "korisnikId": 8,
        "zavrseno": true
    },
    {
        "id": 5,
        "nazivProizvoda": "jahta",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 1000000,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 9,
        "korisnikId": 10,
        "zavrseno": true
    },
    {
        "id": 6,
        "nazivProizvoda": "voz",
        "dodatneInformacije": "dodatneInformacije",
        "cijena": 50000,
        "datumObjave": null,
        "datumZavrsetka": null,
        "podkategorijaId": 11,
        "korisnikId": 12,
        "zavrseno": true
    }
]
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8080/katalozi
[{"id":1,"nazivProizvoda":"mobitel","dodatneInformacije":"dodatneInformacije","cijena":250,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":1,"korisnikId":2,"zavrseno":true},{"id":2,"nazivProizvoda":"auto","dodatneInformacije":"dodatneInformacije","cijena":5500,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":3,"korisnikId":4,"zavrseno":true},{"id":3,"nazivProizvoda":"avion","dodatneInformacije":"dodatneInformacije","cijena":1000000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":5,"korisnikId":6,"zavrseno":true},{"id":4,"nazivProizvoda":"kamion","dodatneInformacije":"dodatneInformacije","cijena":20000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":7,"korisnikId":8,"zavrseno":true},{"id":5,"nazivProizvoda":"jahta","dodatneInformacije":"dodatneInformacije","cijena":1000000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":9,"korisnikId":10,"zavrseno":true},{"id":6,"nazivProizvoda":"voz","dodatneInformacije":"dodatneInformacije","cijena":50000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":11,"korisnikId":12,"zavrseno":true}]

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Prikaži kataloge sa id-om
----
  Dohvati katalog sa id-om

* **URL**

  </katalozi/katalogSaId?id=1>

* **Method:**

  `GET` 

*  **URL Params**
  <id>
* **Data Params**


* **Success Response:**
```json
{
    "id": 1,
    "nazivProizvoda": "mobitel",
    "dodatneInformacije": "dodatneInformacije",
    "cijena": 250,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8080/katalozi/katalogSaId?id=1
{"id":1,"nazivProizvoda":"mobitel","dodatneInformacije":"dodatneInformacije","cijena":250,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":1,"korisnikId":2,"zavrseno":true}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Izmjeni katalog sa id-om
----
  Dohvati katalog sa id-om ili ga kreiraj

* **URL**

  </katalozi?id=1>

* **Method:**

  `PUT` 

*  **URL Params**
  <id>
* **Data Params**
  
  <Katalog>

```json
{
    "nazivProizvoda": "bijela tehnika",
    "dodatneInformacije": "nema povrata novca",
    "cijena": 250000,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Success Response:**
```json
{
    "id": 1,
    "nazivProizvoda": "bijela tehnika",
    "dodatneInformacije": "nema povrata novca",
    "cijena": 250000,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Error Response:**
* **Sample Call:**

curl -X PUT -H "Content-Type: application/json" -d "{""id"":1,""nazivProizvoda"": ""bijela tehnika"",""cijena"": 250000,""datumObjave"": null,""datumZavrsetka"": null, ""podkategorijaId"": 1, ""korisnikId"": 2, ""zavrseno"": true}" "http://localhost:8080/katalozi?id=1"
{"id":1,"nazivProizvoda":"bijela tehnika","dodatneInformacije":null,"cijena":250000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":1,"korisnikId":2,"zavrseno":true}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Dodaj novi katalog
----
  Dodavanje kataloga

* **URL**

  </katalozi>

* **Method:**

  `POST` 

*  **URL Params**
  
* **Data Params**
  
  <Katalog>
```json
{
    "nazivProizvoda": "crna tehnika",
    "dodatneInformacije": "nema povrata novca",
    "cijena": 250000,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Success Response:**
```json
{
    "id": 10,
    "nazivProizvoda": "crna tehnika",
    "dodatneInformacije": "nema povrata novca",
    "cijena": 250000,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Error Response:**
* **Sample Call:**

curl -X POST -H "Content-Type: application/json" -d "{""id"":1,""nazivProizvoda"": ""crna tehnika"",""cijena"": 250000,""datumObjave"": null,""datumZavrsetka"": null, ""podkategorijaId"": 1, ""korisnikId"": 2, ""zavrseno"": true}" "http://localhost:8080/katalozi?id=1"
{"id":10,"nazivProizvoda":"bijela tehnika","dodatneInformacije":null,"cijena":250000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":1,"korisnikId":2,"zavrseno":true}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------


Izbriši postojeći katalog
----
  Brisanje kataloga

* **URL**

  </katalozi>

* **Method:**

  `DELETE` 

*  **URL Params**
  
* **Data Params**
  
  <Katalog>
```json
{
    "id": 10,
    "nazivProizvoda": "crna tehnika",
    "dodatneInformacije": "nema povrata novca",
    "cijena": 250000,
    "datumObjave": null,
    "datumZavrsetka": null,
    "podkategorijaId": 1,
    "korisnikId": 2,
    "zavrseno": true
}
```
* **Success Response:**

* **Error Response:**
* **Sample Call:**

curl -X DELETE -H "Content-Type: application/json" -d "{""id"":1,""nazivProizvoda"": ""crna tehnika"",""cijena"": 250000,""datumObjave"": null,""datumZavrsetka"": null, ""podkategorijaId"": 1, ""korisnikId"": 2, ""zavrseno"": true}" "http://localhost:8080/katalozi?id=1"
{"id":10,"nazivProizvoda":"bijela tehnika","dodatneInformacije":null,"cijena":250000,"datumObjave":null,"datumZavrsetka":null,"podkategorijaId":1,"korisnikId":2,"zavrseno":true}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------