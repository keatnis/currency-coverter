package com.keatnis.exception;

public class RuntimeExceptionAPIConnection extends RuntimeException {
   private  String menssage;
    public RuntimeExceptionAPIConnection(String menssage) {
    this.menssage = menssage;
    }

    @Override
    public String getMessage() {
        return this.menssage;
    }
}
