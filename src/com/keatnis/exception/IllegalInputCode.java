package com.keatnis.exception;

public class IllegalInputCode extends IllegalStateException{
    private String menssage;
    public IllegalInputCode(String menssage) {
       this.menssage = menssage;
    }

    @Override
    public String getMessage() {
        return this.menssage;
    }
}
