Prikaže sve korisnike
----
  Dohvati sve korisnike

* **URL**

  </korisnici>

* **Method:**

  `GET` 

*  **URL Params**

* **Data Params**


* **Success Response:**
```json
[
    {
        "id": 1,
        "firstName": "Jack",
        "lastName": "Bauer",
        "location": "Visoko",
        "email": "Iomanovic1@etf.unsa.ba",
        "phone": "062/111-111"
    },
    {
        "id": 2,
        "firstName": "Chloe",
        "lastName": "O'Brian",
        "location": "Visoko",
        "email": "Iomanovic1@etf.unsa.ba",
        "phone": "062/111-111"
    },
    {
        "id": 3,
        "firstName": "Kim",
        "lastName": "Bauer",
        "location": "Visoko",
        "email": "Iomanovic1@etf.unsa.ba",
        "phone": "062/111-111"
    },
    {
        "id": 4,
        "firstName": "David",
        "lastName": "Palmer",
        "location": "Visoko",
        "email": "Iomanovic1@etf.unsa.ba",
        "phone": "062/111-111"
    },
    {
        "id": 5,
        "firstName": "Michelle",
        "lastName": "Dessler",
        "location": "Visoko",
        "email": "Iomanovic1@etf.unsa.ba",
        "phone": "062/111-111"
    }
] 
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8081/korisnici
[{"id":1,"firstName":"Jack","lastName":"Bauer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"},{"id":2,"firstName":"Chloe","lastName":"O'Brian","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"},{"id":3,"firstName":"Kim","lastName":"Bauer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"},{"id":4,"firstName":"David","lastName":"Palmer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"},{"id":5,"firstName":"Michelle","lastName":"Dessler","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}]

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Prikaži korisnika sa id-om
----
  Dohvati korisnika sa id-om

* **URL**

  </korisnici/korisnikSaId?id=1>

* **Method:**

  `GET` 

*  **URL Params**
  <id>
* **Data Params**


* **Success Response:**
```json
{
    "id": 1,
    "firstName": "Jack",
    "lastName": "Bauer",
    "location": "Visoko",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8081/korisnici/korisnikSaId?id=1
{"id":1,"firstName":"Jack","lastName":"Bauer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Prikaži korisnika/e sa imenom
----
  Dohvati korisnika/e sa imenom

* **URL**

  </korisnici/ime?firstName=Kim>

* **Method:**

  `GET` 

*  **URL Params**
  <firstName>
* **Data Params**


* **Success Response:**
```json
{
    "id": 3,
    "firstName": "Kim",
    "lastName": "Bauer",
    "location": "Visoko",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8081/korisnici/ime?firstName=Kim
{"id":3,"firstName":"Kim","lastName":"Bauer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Prikaži korisnika/e sa prezimenom
----
  Dohvati korisnika/e sa prezimenom

* **URL**

  </korisnici/prezime?lastName=Bauer>

* **Method:**

  `GET` 

*  **URL Params**
  <lastName>
* **Data Params**


* **Success Response:**
```json
{
    "id": 3,
    "firstName": "Kim",
    "lastName": "Bauer",
    "location": "Visoko",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Error Response:**
* **Sample Call:**

curl http://localhost:8081/korisnici/prezime?lastName=Bauer
{"id":3,"firstName":"Kim","lastName":"Bauer","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Izmjeni korisnika sa id-om
----
  Dohvati korisnika sa id-om ili ga kreiraj

* **URL**

  </korisnici?id=1>

* **Method:**

  `PUT` 

*  **URL Params**
  <id>
* **Data Params**
  
  <Katalog>
```json
{
    "firstName": "Amir",
    "lastName": "Sijah",
    "location": "Visoko",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Success Response:**
```json
{
    "id": 1,
    "firstName": "Amir",
    "lastName": "Sijah",
    "location": "Visoko",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Error Response:**
* **Sample Call:**

curl -X PUT -H "Content-Type: application/json" -d "{""id"":1,""firstName"": ""Amir"",""lastName"": ""Sijah"",""location"": ""Visoko"",""email"": ""Iomanovic1@etf.unsa.ba"", ""phone"": ""062/111-111""}" "http://localhost:8081/korisnici?id=1"
{"id":1,"firstName":"Amir","lastName":"Sijah","location":"Visoko","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------

Dodaj novog korisnika
----
  
	Dodaj novog korisnika

* **URL**

  </korisnici>

* **Method:**

  `POST` 

*  **URL Params**
  
* **Data Params**
  
  <Katalog>
```json
{
    "firstName": "Ferhad",
    "lastName": "Mesic",
    "location": "Cazin",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Success Response:**
```json
{
    "id": 6,
    "firstName": "Ferhad",
    "lastName": "Mesic",
    "location": "Cazin",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Error Response:**
* **Sample Call:**

curl -X POST -H "Content-Type: application/json" -d "{""firstName"": ""Ferhad"",""lastName"": ""Mesic"",""location"": ""Cazin"",""email"": ""Iomanovic1@etf.unsa.ba"", ""phone"": ""062/111-111""}" "http://localhost:8081/korisnici"
{"id":10,"firstName":"Ferhad","lastName":"Mesic","location":"Cazin","email":"Iomanovic1@etf.unsa.ba","phone":"062/111-111"}

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------


Izbriši postojećeg korisnika
----
  Brisanje korisnika

* **URL**

  </korisnici>

* **Method:**

  `DELETE` 

*  **URL Params**
  
* **Data Params**
  
  <Katalog>
```json
{
    "id": 6,
    "firstName": "Ferhad",
    "lastName": "Mesic",
    "location": "Cazin",
    "email": "Iomanovic1@etf.unsa.ba",
    "phone": "062/111-111"
}
```
* **Success Response:**

* **Error Response:**
* **Sample Call:**

curl -X DELETE -H "Content-Type: application/json" -d "{""id"":6,""firstName"": ""Ferhad"",""lastName"": ""Mesic"",""location"": ""Cazin"",""email"": ""Iomanovic1@etf.unsa.ba"", ""phone"": ""062/111-111""}" "http://localhost:8081/korisnici"

* **Notes:**
  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
--------------------------------------------------------------------------------------------------------------------------------------------------------