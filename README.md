# NAPREDNE WEB TEHNOLOGIJE

## Uputstvo za pokretanje projekata

### Potrebni preduslovi:

* Lokalno instalirana java (1.8);
* Baza H2 Database Engine.

### Pokretanje projekta

* Za povezivanje mikroservisa korištena je Eureka i potrebno je da bude pokrenuta kako bi mikroservisi mogli međusobno da komuniciraju.    * Pozicioniramo se u direktorij eureka-service te unosimo komandu "mvn spring-boot:run". 
* Nakon ćega se pozicioniramo u direktorij željenog mikroservisa te ponovo unosimo komandu "mvn spring-boot:run" i mikroservis je pokrenut (isto uradimo i za preostale mikroservise). Za svaki od mikroservisa prethodno je odabran jedinstven port kako bi se svi mikroservisi mogli istovremeno pokrenuti.
