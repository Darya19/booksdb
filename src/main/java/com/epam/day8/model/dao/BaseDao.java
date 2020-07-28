package com.epam.day8.model.dao;

import com.epam.day8.exception.BookDaoException;

import java.sql.SQLException;
import java.sql.Statement;

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
}
