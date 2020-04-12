package com.projekat.Katalog.exception;

public class KatalogException extends RuntimeException {

	public KatalogException() {
		super("Traženi katalog ne postoji");
	}
	public KatalogException(String poruka) {
		super("Nema niti jednog kataloga u bazi");
	}
}
