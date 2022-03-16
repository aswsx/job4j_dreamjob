package ru.job4j.dreamjob.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 11:38
 */
public class Post {
    private int id;
    private String name;
    private String description;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private final String created = LocalDateTime.now().format(timeFormatter);

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
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