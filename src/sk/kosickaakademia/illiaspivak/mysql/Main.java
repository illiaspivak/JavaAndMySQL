package sk.kosickaakademia.illiaspivak.mysql;

import sk.kosickaakademia.illiaspivak.mysql.entity.City;
import sk.kosickaakademia.illiaspivak.mysql.entity.Country;
import sk.kosickaakademia.illiaspivak.mysql.output.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Output output = new Output();
        String name = "Ukraine";

        database.updatePopulation("Ukraine", "Konotop", 80000);


        List<City> list = database.getCities(name);
        output.printCities(list);

        List<String> list1 = database.getCountryCodeInContinent("Europe");
        output.printCountryInContinent(list1);

        Country country = database.getCountryInfo(name);
        output.printCountryInfo(country);

        //City newCity = new City("Hadiach",23341, "Poltava Oblast","Ukraine");
        //database.insertCity(newCity);
    }
}
