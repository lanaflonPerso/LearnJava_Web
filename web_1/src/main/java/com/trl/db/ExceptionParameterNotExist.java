package com.trl.db;

public class ExceptionParameterNotExist extends Exception{

    public ExceptionParameterNotExist(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ExceptionParameterNotExist{} " + super.toString();
    }
}

