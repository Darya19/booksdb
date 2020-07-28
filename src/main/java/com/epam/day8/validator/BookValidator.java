package com.epam.day8.validator;

public class BookValidator {

    private final int pagesMaxValue = 1000;
    private final int pagesMinValue = 1;
    private final double priceMinValue = 15.5;
    private final double priceMaxValue = 1450.0;
    private final int titleMaxLength = 100;
    private final int titleMinLength = 3;
    private final int authorsMinNumber = 1;
    private final int authorsMaxNumber = 5;

    public boolean isPageQuantityValid(int pages) {
        return pages < pagesMaxValue && pages > pagesMinValue;
    }

    public boolean isPriceValid(double price) {
        return price > priceMinValue && price < priceMaxValue;
    }

    public boolean isTitleValid(String title) {
        return title.length() > titleMinLength && title.length() < titleMaxLength;
    }

    public boolean isAuthorsListValid(String[] authors) {
        return authors.length >= authorsMinNumber && authors.length < authorsMaxNumber;
    }
}
