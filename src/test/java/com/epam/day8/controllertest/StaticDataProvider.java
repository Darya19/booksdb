package com.epam.day8.controllertest;

import com.epam.day8.model.entity.Book;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticDataProvider {

    @DataProvider(name = "all books")
    public static Object[] listOfBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, 458.96, 194));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219));
        bookList.add(new Book(3, "Airport", new String[]{"Arthur Hailey"}, 746.36, 277));
        bookList.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        bookList.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        bookList.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        bookList.add(new Book(7, "The Sunny Side", new String[]{"Alan Alexander Milne"}, 361.02, 236));
        bookList.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        return new Object[]{bookList};
    }

    @DataProvider(name = "invalid book")
    public static Object[] invalidBooks() {
        Map<String, String[]> book = new HashMap<>();
        book.put("title", new String[]{"Harry      Potter a  nd the chamber of secrets111111111000  001111111100 0  0014444" +
                "55558963ggffggnnnnbggd"});
        book.put("authors", new String[]{"J.K. Rowling"});
        book.put("price", new String[]{"942.38"});
        book.put("pages", new String[]{"615"});
        Map<String, String[]> book1 = new HashMap<>();
        book1.put("title", new String[]{"Ha"});
        book1.put("authors", new String[]{"J.K. Rowling"});
        book1.put("price", new String[]{"942.38"});
        book1.put("pages", new String[]{"615"});
        Map<String, String[]> book2 = new HashMap<>();
        book2.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book2.put("authors", new String[]{"J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling"});
        book2.put("price", new String[]{"942.38"});
        book2.put("pages", new String[]{"615"});
        Map<String, String[]> book3 = new HashMap<>();
        book3.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book3.put("authors", new String[]{"J.K. Rowling"});
        book3.put("price", new String[]{"3.3"});
        book3.put("pages", new String[]{"615"});
        Map<String, String[]> book4 = new HashMap<>();
        book4.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book4.put("authors", new String[]{"J.K. Rowling"});
        book4.put("price", new String[]{"1458.36"});
        book4.put("pages", new String[]{"615"});
        Map<String, String[]> book5 = new HashMap<>();
        book5.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book5.put("authors", new String[]{"J.K. Rowling"});
        book5.put("price", new String[]{"617.36"});
        book5.put("pages", new String[]{"-3"});
        Map<String, String[]> book6 = new HashMap<>();
        book6.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book6.put("authors", new String[]{"J.K. Rowling"});
        book6.put("price", new String[]{"617.36"});
        book6.put("pages", new String[]{"-985"});
        return new Object[]{book, book1, book2, book3, book4, book5, book6};
    }

    @DataProvider(name = "incorrect book")
    public static Object[] incorrectBooks() {
        Map<String, String[]> book = new HashMap<>();
        book.put("title", new String[]{"Harry Potter a  nd the chamber of secrets"});
        book.put("authors", new String[]{"J.K. Rowling"});
        book.put("price", new String[]{"number"});
        book.put("pages", new String[]{"615"});
        Map<String, String[]> book1 = new HashMap<>();
        book1.put("title", new String[]{"Ha"});
        book1.put("authors", new String[]{"J.K. Rowling"});
        book1.put("price", new String[]{"942.38"});
        book1.put("pages", new String[]{"number"});
        Map<String, String[]> book2 = new HashMap<>();
        book2.put("title", new String[]{"Harry Potter and the chamber of secrets"});
        book2.put("authors", new String[]{""});
        book2.put("price", new String[]{"number"});
        book2.put("pages", new String[]{"number"});
        return new Object[]{book, book1, book2};
    }

    @DataProvider(name = "sorted by title archive")
    public static Object[] sortByTitle() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(3, "Airport", new String[]{"Arthur Hailey"}, 746.36, 277));
        bookList.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219));
        bookList.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        bookList.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        bookList.add(new Book(7, "The Sunny Side", new String[]{"Alan Alexander Milne"}, 361.02, 236));
        bookList.add(new Book(1, "Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, 458.96, 194));
        bookList.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        return new Object[]{bookList};
    }

    @DataProvider(name = "sorted by authors archive")
    public static Object[] sortByAuthor() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(7, "The Sunny Side", new String[]{"Alan Alexander Milne"}, 361.02, 236));
        bookList.add(new Book(1, "Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, 458.96, 194));
        bookList.add(new Book(3, "Airport", new String[]{"Arthur Hailey"}, 746.36, 277));
        bookList.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        bookList.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219));
        bookList.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        bookList.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        return new Object[]{bookList};
    }

    @DataProvider(name = "sorted by price archive")
    public static Object[] sortByPrice() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        bookList.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        bookList.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        bookList.add(new Book(7, "The Sunny Side", new String[]{"Alan Alexander Milne"}, 361.02, 236));
        bookList.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        bookList.add(new Book(1, "Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, 458.96, 194));
        bookList.add(new Book(3, "Airport", new String[]{"Arthur Hailey"}, 746.36, 277));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219));
        return new Object[]{bookList};
    }

    @DataProvider(name = "sorted by pages archive")
    public static Object[] sortByPages() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, 458.96, 194));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219));
        bookList.add(new Book(7, "The Sunny Side", new String[]{"Alan Alexander Milne"}, 361.02, 236));
        bookList.add(new Book(3, "Airport", new String[]{"Arthur Hailey"}, 746.36, 277));
        bookList.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        bookList.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        bookList.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        bookList.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        return new Object[]{bookList};
    }
}
