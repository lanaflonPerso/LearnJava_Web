package com.trl.beans;

import com.trl.db.ConnectionPostgreSQL;
import com.trl.db.ExceptionParameterNotExist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {

    private ArrayList<Book> bookList = new ArrayList<>();
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(AuthorList.class);

    private ArrayList<Book> getBooks() {

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = ConnectionPostgreSQL.getConnection();


            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from book order by name");
            while (resultSet.next()) {
                Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setPublishDate(resultSet.getDate("publish_date"));
                book.setPublisher(resultSet.getString("publisher"));
                bookList.add(book);
                LOG.debug("AuthorList getAuthors() --->>> " + book.getName());

            }

        } catch (SQLException ex) {
            LOG.error(ex);
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            LOG.error(exceptionParameterNotExist);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return bookList;
    }

    public ArrayList<Book> getBookList() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getBooks();
        }
    }
    
}
