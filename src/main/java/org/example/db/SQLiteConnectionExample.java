package org.example.db;

import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteConnectionExample {
    private static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\Haci\\IdeaProjects\\Word\\src\\main\\resources\\db\\iddia.db";

    public static List<String> getAllowedWords() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM bankOfRepublic1";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("deyisilmeliOlan"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> bankOfRepublicSuallar() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM bankOfRepublic2";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("suallar"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }

    public static void main(String[] args) {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(DATABASE_URL);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
