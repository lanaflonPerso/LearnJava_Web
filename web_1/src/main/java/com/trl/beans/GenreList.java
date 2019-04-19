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

public class GenreList {

    private ArrayList<Genre> genreList = new ArrayList<>();

    private ArrayList<Genre> getGenres() {

        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = ConnectionPostgreSQL.getConnection();

            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            exceptionParameterNotExist.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return genreList;
    }

    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
}
