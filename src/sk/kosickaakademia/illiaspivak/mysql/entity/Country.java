package sk.kosickaakademia.illiaspivak.mysql.entity;

public class Country {
    private String name;
    private String code3;
    private String capitalCity;
    private int area;
    private String continent;
    private int pop;

    public Country(String name, String capitalCity, int pop) {
        this.name = name;
        this.capitalCity = capitalCity;
        this.pop = pop;
    }

    public Country(String name, String code3, String capitalCity, int area, String continent) {
        this.name = name;
        this.code3 = code3;
        this.capitalCity = capitalCity;
        this.area = area;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getCode3() {
        return code3;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public int getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public int getPop() {
        return pop;
    }
}
