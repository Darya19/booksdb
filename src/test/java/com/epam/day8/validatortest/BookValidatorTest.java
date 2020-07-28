package com.epam.day8.validatortest;

import com.epam.day8.validator.BookValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class BookValidatorTest {

    BookValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new BookValidator();
    }

    @Test
    public void isTitleValidTrueTest() {
        assertTrue(validator.isTitleValid("Harry Potter"));
    }

    @Test
    public void isTitleValidFalseTest() {
        assertFalse(validator.isTitleValid("jk"));
    }

    @Test
    public void isAuthorsListValidTrueTest() {
        assertTrue(validator.isAuthorsListValid(new String[]{"N. Nosov"}));
    }

    @Test
    public void validateNumberFalseTest() {
        assertFalse(validator.isAuthorsListValid(new String[0]));
    }

    @Test
    public void isPriceValidTrueTest() {
        assertTrue(validator.isPriceValid(192));
    }

    @Test
    public void isPriceValidFalseTest() {
        assertFalse(validator.isPriceValid(-14));
    }

    @Test
    public void isPageQuantityValidTrueTest() {
        assertTrue(validator.isPageQuantityValid(269));
    }

    @Test
    public void isPageQuantityValidFalseTest() {
        assertFalse(validator.isPageQuantityValid(-85));
    }
}
