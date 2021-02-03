package sk.kosickaakademia.illiaspivak.mysql.output;

import sk.kosickaakademia.illiaspivak.mysql.entity.City;

import java.util.List;

public class Output {
    public void printCities(List<City> cities){
        System.out.println("List of cities: ");
        for(City c : cities){
            System.out.println("   - "+c.getName()+ " ( "+c.getPopulation()+" ) ");
        }
    }
}
