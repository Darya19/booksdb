package com.epam.day8.model.dao.impl;

import com.epam.day8.exception.BookDaoException;
import com.epam.day8.model.connector.ConnectorDB;
import com.epam.day8.model.dao.BaseDao;
import com.epam.day8.model.dao.BookListDao;
import com.epam.day8.model.dao.ColumnName;
import com.epam.day8.model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookListDaoImpl implements BookListDao, BaseDao {

    private final static String ADD_BOOK =
            "INSERT INTO books(title, authors, price, pages ) VALUES(?,?,?,?)";
    private final static String REMOVE_BOOK =
            "DELETE FROM books WHERE title=? AND authors=? AND price=? AND pages=?";
    private final static String GET_ALL_BOOKS = "SELECT id, title, authors, price, pages FROM books";
    private final static String FIND_BY_ID = "SELECT id, title, authors, price, pages  FROM books where id=? ";
    private final static String FIND_BY_TITLE =
            "SELECT id, title, authors, price, pages  FROM books where title=? ORDER BY title";
    private final static String FIND_BY_AUTHOR =
            "SELECT id, title, authors, price, pages  FROM books where authors LIKE ? ORDER BY authors";
    private final static String FIND_BY_PRICE =
            "SELECT id, title, authors, price, pages  FROM books where price BETWEEN ? AND ? ORDER BY price";
    private final static String FIND_BY_PAGES =
            "SELECT id, title, authors, price, pages  FROM books where pages BETWEEN ? AND ? ORDER BY pages";
    private final static String SORT_ALL_BOOKS_BY_TITLE = "SELECT id, title, authors, price, pages FROM books ORDER BY title";
    private final static String SORT_ALL_BOOKS_BY_AUTHOR = "SELECT id, title, authors, price, pages FROM books ORDER BY authors";
    private final static String SORT_ALL_BOOKS_BY_PRICE = "SELECT id, title, authors, price, pages FROM books ORDER BY price";
    private final static String SORT_ALL_BOOKS_BY_PAGES = "SELECT id, title, authors, price, pages FROM books ORDER BY pages";

    @Override
    public int addBook(Book book) throws BookDaoException {
        String author = Arrays.toString(book.getAuthors());
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, author.substring(1, author.length() - 1));
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getPages());
            int updateRows = statement.executeUpdate();
            return updateRows;
        } catch (SQLException e) {
            throw new BookDaoException("database issues");
        }
    }

    @Override
    public int removeBook(Book book) throws BookDaoException {
        String author = Arrays.toString(book.getAuthors());
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, author.substring(1, author.length() - 1));
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getPages());
            int updateRows = statement.executeUpdate();
            return updateRows;
        } catch (SQLException e) {
            throw new BookDaoException("database issues");
        }
    }

    @Override
    public List<Book> findById(int... id) throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            if (id.length != 0) {
                statement = connection.prepareStatement(FIND_BY_ID);
                statement.setInt(1, id[0]);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            } else {
                statement = connection.prepareStatement(GET_ALL_BOOKS);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Book> findByTitle(String... title) throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            if (title.length != 0) {
                statement = connection.prepareStatement(FIND_BY_TITLE);
                statement.setString(1, title[0]);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            } else {
                statement = connection.prepareStatement(SORT_ALL_BOOKS_BY_TITLE);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Book> findByAuthor(String... author) throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            if (author.length != 0) {
                statement = connection.prepareStatement(FIND_BY_AUTHOR);
                statement.setString(1, "%" + author[0] + "%");
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            } else {
                statement = connection.prepareStatement(SORT_ALL_BOOKS_BY_AUTHOR);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Book> findByPrice(double... price) throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            if (price.length != 0) {
                statement = connection.prepareStatement(FIND_BY_PRICE);
                statement.setDouble(1, price[0]);
                statement.setDouble(2, price[1]);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            } else {
                statement = connection.prepareStatement(SORT_ALL_BOOKS_BY_PRICE);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Book> findByPages(int... pages) throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            if (pages.length != 0) {
                statement = connection.prepareStatement(FIND_BY_PAGES);
                statement.setInt(1, pages[0]);
                statement.setInt(2, pages[1]);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            } else {
                statement = connection.prepareStatement(SORT_ALL_BOOKS_BY_PAGES);
                ResultSet resultSet = statement.executeQuery();
                List<Book> foundBooks = createBookListFromResultSet(resultSet);
                return foundBooks;
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Book> getAllBooks() throws BookDaoException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectorDB.getConnection()) {
            statement = connection.prepareStatement(GET_ALL_BOOKS);
            ResultSet resultSet = statement.executeQuery();
            List<Book> foundBooks = createBookListFromResultSet(resultSet);
            return foundBooks;
        } catch (SQLException e) {
            throw new BookDaoException("database issues");
        } finally {
            closeStatement(statement);
        }
    }

    private List<Book> createBookListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt(ColumnName.ID));
            book.setTitle(resultSet.getString(ColumnName.TITLE));
            book.setAuthors(resultSet.getString(ColumnName.AUTHORS).split(", "));
            book.setPrice(resultSet.getDouble(ColumnName.PRICE));
            book.setPages(resultSet.getInt(ColumnName.PAGES));
            books.add(book);
        }
        return books;
    }
}
