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
        List<City> list = database.getCities(name);
        output.printCities(list);

        Country country = database.getCountryInfo(name);
        output.printCountryInfo(country);

        City newCity = new City("Hadiach",23341, "Poltava Oblast","Ukraine");
        database.insertCity(newCity);
    }
}
