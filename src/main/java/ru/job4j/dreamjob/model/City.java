package ru.job4j.dreamjob.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author Alex Gutorov
 * @version 1.1
 * @created 20/03/2022 - 21:14
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class City implements Serializable {
    private int id;
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
}
