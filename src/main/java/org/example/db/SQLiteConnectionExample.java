package org.example.db;

import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteConnectionExample {
    private static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\Haci\\IdeaProjects\\Word\\src\\main\\resources\\db\\iddia.db";

    public static List<byte[]> wordFiles() {
        List<byte[]> fileDataList = new ArrayList<>();
        String query = "SELECT * FROM wordFiles";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                byte[] fileData = resultSet.getBytes("files");
                fileDataList.add(fileData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return fileDataList;
    }




    public static List<String> getAllowedWords() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM bankOfRepublic1";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("deyisilmeliSozler"));
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
                allowedWords.add(resultSet.getString("sozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> ABC1Telefon() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM ABC1telefon";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("sozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> ABC2Telefon() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM ABC2telefon";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("deyisilmeliSozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }

    public static List<String> ABC1Mehsul() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM ABC1mehsul";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("sozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> ABC2Mehsul() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM ABC2mehsul";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("deyisilmeliSozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }

    public static List<String> FerrumKapital1() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM FerrumKapital1";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("sozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> FerrumKapital2() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM FerrumKapital2";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("deyisilmeliSozler"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> muessiseAdlari() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM muessiseAdlari";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("adlar"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allowedWords;
    }
    public static List<String> proqramSozleri() {
        List<String> allowedWords = new ArrayList<>();
        String query = "SELECT * FROM proqramdaIstifadeOlunanSozler";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allowedWords.add(resultSet.getString("sozler"));
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
