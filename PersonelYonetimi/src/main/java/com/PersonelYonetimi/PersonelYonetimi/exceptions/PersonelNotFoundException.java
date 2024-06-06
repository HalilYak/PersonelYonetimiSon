package com.PersonelYonetimi.PersonelYonetimi.exceptions;

public class PersonelNotFoundException extends RuntimeException {
    public PersonelNotFoundException() {
        super();
    }

    public PersonelNotFoundException(String message) {
        super(message);
    }
}
