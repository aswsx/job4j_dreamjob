package ru.job4j.dreamjob.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Candidate)) {
            return false;
        }

        Candidate candidate = (Candidate) o;

        if (id != candidate.id) {
            return false;
        }
        return name != null ? name.equals(candidate.name) : candidate.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String
                .format("Candidate(id=%s, name=%s, description=%s, created=%s)",
                        this.id, this.name, this.description, this.created);
    }
}
