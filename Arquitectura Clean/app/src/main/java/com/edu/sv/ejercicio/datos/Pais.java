package com.edu.sv.ejercicio.datos;

public class Pais {
    private String nombre;
    private String capital;
    private String idioma;
    private String moneda;
    private String inf;
    String key;

    public Pais() {
    }

    public Pais(String nombre, String capital, String idioma, String moneda, String inf) {
        this.nombre = nombre;
        this.capital = capital;
        this.idioma = idioma;
        this.moneda = moneda;
        this.inf = inf;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}



