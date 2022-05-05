package ru.job4j.dreamjob.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 21:37
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Candidate implements Serializable {
    private int id;
    private String name;
    private String description;
    private byte[] photo;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private String created = LocalDateTime.now().format(timeFormatter);

    public Candidate() {
    }

    public Candidate(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Candidate(String name) {
        this.name = name;
    }
}
