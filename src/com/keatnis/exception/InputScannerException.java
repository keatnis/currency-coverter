package com.keatnis.exception;

import java.util.InputMismatchException;

public class InputScannerException  extends InputMismatchException {
 private String menssage;

    public InputScannerException(String menssage) {
        this.menssage = menssage;
    }

    @Override
    public String getMessage() {
        return this.menssage;
    }
}
