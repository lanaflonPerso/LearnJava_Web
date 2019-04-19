package com.trl;

public class Calculator {

    public static double calcResult(OperationType operType, double one, double two) {

        double result = 0;

        switch (operType) {
            case ADD:
                result = one + two;
                break;
            case SUBTRACT:
                result = one - two;
                break;
            case DIVIDE:
                result = one / two;
                break;
            case MULTIPLY:
                result = one + two;
                break;
        }
        return result;
    }
}