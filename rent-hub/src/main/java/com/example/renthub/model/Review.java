package com.example.renthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Требуется комментарий.")
    @Size(max = 500, message = "Комментарий должен быть менее 500символов.")
    private String comment;

    @NotNull(message = "Требуется рейтинг.")
    @Min(value = 1, message = "Оценка должна быть не ниже 1")
    @Max(value = 5, message = "Оценка должна быть не более 5")
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @NotNull(message = "Требуется пользователь.")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Связь с пользователем

    @NotNull(message = "Требуется недвижимость.")
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property; // Связь с недвижимостью
}
