package com.epam.day8.parser;

import com.epam.day8.exception.BookServiceException;

public class NumberParser {

    public int parseToInt(String value) throws BookServiceException {
        try {
            int intValue = Integer.parseInt(value);
            return intValue;
        } catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues", e);
        }
    }

    public double parseToDouble(String value) throws BookServiceException {
        try {
            double doubleValue = Double.parseDouble(value);
            return doubleValue;
        } catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues", e);
        }
    }

    public int[] parseToIntMassive(String... values) throws BookServiceException {
        int[] intValue = new int[values.length];
        try {
            for (int i = 0; i < values.length; i++) {
                intValue[i] = Integer.parseInt(values[i]);
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues", e);
        }
    }

    public double[] parseToDoubleMassive(String... values) throws BookServiceException {
        double[] doubleValue = new double[values.length];
        try {
            for (int i = 0; i < values.length; i++) {
                doubleValue[i] = Integer.parseInt(values[i]);
            }
            return doubleValue;
        } catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues", e);
        }
    }
}
