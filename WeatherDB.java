package Dz_8;

import java.io.IOException;
import java.sql.*;


public class WeatherDB {
    private static String cityName = null;

    public static void main(String[] args) throws IOException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            DBActions.connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
            DBActions.statement = DBActions.connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBActions.performCreateDB();
        for (int i = 0; i <= 2; i++) {
            DBActions.preparedStatement(APIactions.getWeather(), APIactions.getCityName());
        }
        ValidateInput.checkInput();

        System.out.println("-------------------------------------------------------------------------");
        DBActions.connection.close();
    }


}

