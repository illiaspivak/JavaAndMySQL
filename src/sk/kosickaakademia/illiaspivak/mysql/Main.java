package sk.kosickaakademia.illiaspivak.mysql;

import sk.kosickaakademia.illiaspivak.mysql.entity.City;
import sk.kosickaakademia.illiaspivak.mysql.entity.Country;
import sk.kosickaakademia.illiaspivak.mysql.entity.Monument;
import sk.kosickaakademia.illiaspivak.mysql.output.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Output output = new Output();
        String name = "Ukraine";

      //  database.updatePopulation("Ukraine", "Konotop", 80000);


       // List<City> list = database.getCities(name);
       // output.printCities(list);

      //  List<String> list1 = database.getCountryCodeInContinent("Europe");
      //  output.printCountryInContinent(list1);

        Country country = database.getCountryInfo(name);
        output.printCountryInfo(country);

       // Country capitalCity = database.getCapitalCity("UKR");
       // output.printCapitalCity(capitalCity);

       // List<Country> capitalCityList = database.getCapitalCities("Europe");
       // output.printCapitalCities(capitalCityList);

        //City newCity = new City("Hadiach",23341, "Poltava Oblast","Ukraine");
        //database.insertCity(newCity);

       // database.insertNewMonument("UKR" , "Kyiv","Motherland Monument");

        List<Monument> monuments = database.getMonuments();
        output.printMonuments(monuments);
    }
}
