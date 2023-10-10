package com.ssafy;

public class Country {

    private String code;
    private String name;
    private String continent;
    private double gnp;
    
    public Country() {}
    
    public Country(String code, String name, String continent, double gnp) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.gnp = gnp;
    }

	@Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", gnp=" + gnp + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }
    
    
    
    
}
