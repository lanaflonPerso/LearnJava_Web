package com.trl.beans;

import com.trl.db.ConnectionPostgreSQL;
import com.trl.db.ExceptionParameterNotExist;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorList {

    private ArrayList<Author> authorList = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(AuthorList.class);

    private ArrayList<Author> getAuthors() {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = ConnectionPostgreSQL.getConnection();
//            connection = ConnectionPostgreSQL_2.getConnection("URL_DB_test", "USER", "PASSWORD");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from author");
            while (resultSet.next()) {
                Author author = new Author();
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                authorList.add(author);
                LOG.debug("AuthorList getAuthors() --->>> " + author.getFirstName() + " " + author.getLastName());
            }

        } catch (SQLException ex) {
            LOG.error(ex);
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            LOG.error(exceptionParameterNotExist + "88888888888");
            exceptionParameterNotExist.printStackTrace();
        } finally {
            try {
                if (statement!=null) statement.close();
                if (resultSet!=null)resultSet.close();
                if (connection!=null)connection.close();
            } catch (SQLException ex) {
                LOG.error(ex);
            }
        }

        return authorList;
    }

    public List<Author> getAuthorList() {
        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAuthors();
        }
    }
}

