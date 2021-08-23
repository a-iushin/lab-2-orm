package com.luxoft.springdb.lab2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {
    private static final long serialVersionUID = 88005553535L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE_NAME")
    private String codeName;

    public Country() {
    }

    public Country(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Country country = (Country) o;

        if (codeName != null ? !codeName.equals(country.codeName) : country.codeName != null)
            return false;
        if (name != null ? !name.equals(country.name) : country.name != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + ", codeName=" + codeName + "]";
    }
}
