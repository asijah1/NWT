package com.projekat.Korisnik.exception;

public class KorisnikException extends RuntimeException{

	public KorisnikException(long id) {
		super("Trazeni korisnik ne postoji");
	}
	
	public KorisnikException(String iliImeIliPrezime){
        super("Trazeni korisnik ne postoji");
    }
	
	public KorisnikException(String poruka, Integer pom) {
		super("Nema niti jednog korisnika u bazi");
	}
}
