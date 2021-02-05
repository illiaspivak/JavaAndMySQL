package sk.kosickaakademia.illiaspivak.mysql.output;

import sk.kosickaakademia.illiaspivak.mysql.entity.City;
import sk.kosickaakademia.illiaspivak.mysql.entity.Country;

import java.util.List;

public class Output {
    public void printCities(List<City> cities){
        System.out.println("List of cities: ");
        for(City c : cities){
            System.out.println("   - "+c.getName()+ " ( "+c.getPopulation()+" ) ");
        }
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
    }

    public void printCountryInfo(Country country){
        if(country==null){
            System.out.println("Country does not exist !");
        }
        else {
            System.out.println("Name: " + country.getName() + " ( " + country.getCode3() + " )");
            System.out.println("Capital city: " + country.getCapitalCity());
            System.out.println("Continent: " + country.getContinent());
            System.out.println("Surface area : " + country.getArea());
        }
    }

    public void printCountryInContinent(List<String> country){
        System.out.println("List of country: ");
        for(String c : country){
            System.out.println("  - " + c);
        }
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
    }
}
