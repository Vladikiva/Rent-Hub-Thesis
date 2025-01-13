package com.example.renthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Укажите дату начала.")
    @FutureOrPresent(message = "Дата начала должна быть в настоящем или будущем.")
    private LocalDate startDate;

    @NotBlank(message = "Укажите дату окончания.")
    @FutureOrPresent(message = "Дата окончания должна быть в настоящем или будущем.")
    private LocalDate endDate;

    @NotBlank(message = "Общая цена должна быть положительным числом.")
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
