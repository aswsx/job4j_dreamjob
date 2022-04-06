package ru.job4j.dreamjob.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alex Gutorov
 * @version 1.1
 * @created 20/03/2022 - 21:14
 */
@Getter
@Setter
@AllArgsConstructor
public class City implements Serializable {
    private int id;
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
