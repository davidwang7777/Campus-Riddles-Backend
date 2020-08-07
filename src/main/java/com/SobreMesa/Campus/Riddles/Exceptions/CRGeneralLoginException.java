package com.SobreMesa.Campus.Riddles.Exceptions;

public class CRGeneralLoginException extends RuntimeException {
	
    public CRGeneralLoginException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CRGeneralLoginException(String exMessage) {
        super(exMessage);
    }
}
