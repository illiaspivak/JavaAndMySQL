package sk.kosickaakademia.illiaspivak.mysql;

import sk.kosickaakademia.illiaspivak.mysql.entity.City;
import sk.kosickaakademia.illiaspivak.mysql.entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Connect.getUrl(),Connect.getUsername(),Connect.getPassword());
        return conn;
    }

    public List<City> getCities(String country){
        String query = "SELECT city.Name, JSON_EXTRACT(Info,'$.Population') AS Population " +
                "FROM city " +
                "INNER JOIN country ON country.code = city.CountryCode " +
                "WHERE country.name LIKE ? ORDER BY Population DESC";
        List<City> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = getConnection();
            if(connection!=null){
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, country);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String name = rs.getString("Name");
                    int pop = rs.getInt("Population");
                    City city = new City(name,pop);
                    list.add(city);
                }
                connection.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public Country getCountryInfo (String country){
        String query = "SELECT country.name, country.code, city.name, " +
                " JSON_UNQUOTE(JSON_EXTRACT(doc, '$.geography.Continent')) AS Continent, " +
                " JSON_EXTRACT(doc, '$.geography.SurfaceArea') AS Area" +
                " FROM country " +
                " INNER JOIN city ON country.Capital = city.ID " +
                " INNER JOIN countryinfo ON country.code = countryinfo._id " +
                " WHERE country.name like ?";

        Country countryInfo = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, country);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String code3=rs.getString("country.code");
                String capitalCity=rs.getString("city.name");
                String continent=rs.getString("continent");
                int area=rs.getInt("Area");
                countryInfo = new Country(country, code3, capitalCity,area, continent);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return countryInfo;
    }
}
