Prikaže sve ponude
----
  Dohvati sve Ponude

* **URL**

  </ponude>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**
```json
[
    {
        "id": 1,
        "idKatalog": 1,
        "idKorisnik": 1,
        "ponuda": 15
    },
    {
        "id": 2,
        "idKatalog": 2,
        "idKorisnik": 3,
        "ponuda": 11
    },
    {
        "id": 3,
        "idKatalog": 2,
        "idKorisnik": 1,
        "ponuda": 12
    },
    {
        "id": 4,
        "idKatalog": 3,
        "idKorisnik": 1,
        "ponuda": 12
    },
    {
        "id": 5,
        "idKatalog": 4,
        "idKorisnik": 1,
        "ponuda": 11
    },
    {
        "id": 6,
        "idKatalog": 5,
        "idKorisnik": 2,
        "ponuda": 13
    }
]
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8082/ponude
[{"id":1,"idKatalog":1,"idKorisnik":1,"ponuda":15},{"id":2,"idKatalog":2,"idKorisnik":3,"ponuda":11},{"id":3,"idKatalog":2,"idKorisnik":1,"ponuda":12},{"id":4,"idKatalog":3,"idKorisnik":1,"ponuda":12},{"id":5,"idKatalog":4,"idKorisnik":1,"ponuda":11},{"id":6,"idKatalog":5,"idKorisnik":2,"ponuda":13}]

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Prikaži ponudu sa id-om
----
  Dohvati ponudu sa id-om

* **URL**

  </ponude/ponudaSaId?id=1>

* **Method:**

  `GET` 

*  **URL Params**
  <id>
* **Data Params**


* **Success Response:**
```json
{
    "id": 1,
    "idKatalog": 1,
    "idKorisnik": 1,
    "ponuda": 15
}
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8082/ponude/ponudaSaId?id=1
{"id":1,"idKatalog":1,"idKorisnik":1,"ponuda":15}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Izmjeni ponudu sa id-om
----
  Dohvati ponudu sa id-om ili je kreiraj

* **URL**

  </ponude?id=1>

* **Method:**

  `PUT` 

*  **URL Params**
  <id>
* **Data Params**
  
  <Katalog>
```json
{
    "id": 1,
    "idKatalog": 1,
    "idKorisnik": 1,
    "ponuda": 1523435
}
```
* **Success Response:**
```json
{
    "id": 1,
    "idKatalog": 1,
    "idKorisnik": 1,
    "ponuda": 1523435
}
```
* **Error Response:**
* **Sample Call:**

curl -X PUT -H "Content-Type: application/json" -d "{""id"":1,""idKatalog"": 1,""idKorisnik"": 1,""ponuda"": 1523435}" http://localhost:8082/ponude?id=1"
{"id":1,"idKatalog":1,"idKorisnik":1,"ponuda":1523435}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Dodaj novu ponudu
----
  
	Dodaj novu ponudu

* **URL**

  </ponude>

* **Method:**

  `POST` 

*  **URL Params**
  
* **Data Params**
  
  <Katalog>
```json
{
    "idKatalog": 10,
    "idKorisnik": 10,
    "ponuda": 11122233
}
```
* **Success Response:**
```json
{
    "id": 7,
    "idKatalog": 10,
    "idKorisnik": 10,
    "ponuda": 11122233
}
```
* **Error Response:**
* **Sample Call:**

curl -X POST -H "Content-Type: application/json" -d "{""idKatalog"": 10,""idKorisnik"": 10,""ponuda"": 11122233}" "http://localhost:8082/ponude"
{"id":8,"idKatalog":10,"idKorisnik":10,"ponuda":11122233}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------
Izbriši postojeću ponudu
----
  Brisanje ponude

* **URL**

  </korisnici>

* **Method:**

  `DELETE` 

*  **URL Params**
  
* **Data Params**
  
  <Ponuda>
```json
    "id": 7,
    "idKatalog": 10,
    "idKorisnik": 10,
    "ponuda": 11122233
```
* **Success Response:**

* **Error Response:**
* **Sample Call:**

curl -X DELETE -H "Content-Type: application/json" -d "{""id"": 7,""idKatalog"": 10,""idKorisnik"": 10,""ponuda"": 11122233}" "http://localhost:8082/ponude"

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------