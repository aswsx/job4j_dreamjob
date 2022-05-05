package ru.job4j.dreamjob.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 11:38
 */
@Getter
@Setter
@AllArgsConstructor
public class Post implements Serializable {
    private int id;
    private String name;
    private String description;
    private boolean visible;
    private City city;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private String created = LocalDateTime.now().format(timeFormatter);

    private Post() {
    }

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Post(int id, String name, String description, City city, String created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.created = created;
    }

    public Post(String name, String description, City city, String created) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.created = created;
    }


    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }

        Post post = (Post) o;

        if (id != post.id) {
            return false;
        }
        return name != null ? name.equals(post.name) : post.name == null;
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
                .format("Post(id=%s, name=%s, description=%s, created=%s)",
                        this.id, this.name, this.description, this.created);
    }
}
