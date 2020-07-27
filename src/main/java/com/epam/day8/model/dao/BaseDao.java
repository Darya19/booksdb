package com.epam.day8.model.dao;

import com.epam.day8.exception.BookDaoException;
import com.epam.day8.model.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface BaseDao {
    default void closeStatement(Statement statement) throws BookDaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new BookDaoException("database issues", e);
        }
    }

    default List<Book> createBookListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt(ColumnName.ID));
            book.setTitle(resultSet.getString(ColumnName.TITLE));
            book.setAuthors(Arrays.asList(resultSet.getString(ColumnName.AUTHORS).split(", ")));
            book.setPrice(resultSet.getDouble(ColumnName.PRICE));
            book.setPages(resultSet.getInt(ColumnName.PAGES));
            books.add(book);
        }
        return books;
    }
}
