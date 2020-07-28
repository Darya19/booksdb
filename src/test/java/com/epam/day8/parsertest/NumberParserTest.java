package com.epam.day8.parsertest;

import com.epam.day8.exception.BookServiceException;
import com.epam.day8.parser.NumberParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumberParserTest {

    NumberParser parser = new NumberParser();


    @Test
    public void parseToIntMassivePositiveTest() {
        String[] numbers = {"125", "200"};
        try {
            int[] actual = parser.parseToIntMassive(numbers);
            int[] expected = {125, 200};
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void parseToIntMassiveNegativeTest() throws BookServiceException {
        String[] numbers = {"jmh", "120"};
        parser.parseToIntMassive(numbers);
    }

    @Test
    public void parseToIntPositiveTest() {
        String number = "125";
        try {
            int actual = parser.parseToInt(number);
            int expected = 125;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void parseToIntNegativeTest() throws BookServiceException {
        String number = "jmh";
        parser.parseToInt(number);
    }

    @Test
    public void parseToDoubleMassivePositiveTest() {
        String[] numbers = {"125.36", "298.0236"};
        try {
            double[] actual = parser.parseToDoubleMassive(numbers);
            double[] expected = {125.36, 298.0236};
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class)
    public void parseToDoubleMassiveNegativeTest() throws BookServiceException {
        String[] numbers = {"12a.2m", "23.69"};
        parser.parseToDoubleMassive(numbers);
    }

    @Test
    public void parseToDoublePositiveTest() {
        String number = "125.36";
        try {
            double actual = parser.parseToDouble(number);
            double expected = 125.36;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class)
    public void parseToDoubleNegativeTest() throws BookServiceException {
        String number = "12a.2m";
        parser.parseToDouble(number);
    }
}
