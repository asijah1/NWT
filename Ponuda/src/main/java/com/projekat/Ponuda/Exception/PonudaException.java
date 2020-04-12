package com.projekat.Ponuda.Exception;

public class PonudaException extends RuntimeException {
	public PonudaException() {
		super("Tražena ponuda ne postoji");
	}
	public PonudaException(String poruka) {
		super("Nema niti jedne ponude u bazi");
	}
}
