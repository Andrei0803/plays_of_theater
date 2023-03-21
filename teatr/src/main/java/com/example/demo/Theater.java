package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Theater {
    private Long id; // ID
    private String play_title; // Название спектакля
    private String the_name_of_the_cast; // Название коллектива актеров
    private String play_date_and_time; // Время и дата
    private Integer number_of_tickets; // Количество билетов

    private Integer number_of_tickets_free; // Количество свободных билетов

    protected Theater() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlay_title() {
        return play_title;
    }

    public void setPlay_title(String play_title) {
        this.play_title = play_title;
    }

    public String getThe_name_of_the_cast() {
        return the_name_of_the_cast;
    }

    public void setThe_name_of_the_cast(String the_name_of_the_cast) {
        this.the_name_of_the_cast = the_name_of_the_cast;
    }

    public String getPlay_date_and_time() {
        return play_date_and_time;
    }

    public void setPlay_date_and_time(String play_date_and_time) {
        this.play_date_and_time = play_date_and_time;
    }

    public Integer getNumber_of_tickets() {return number_of_tickets;}

    public void setNumber_of_tickets(Integer number_of_tickets) {this.number_of_tickets = number_of_tickets;}

    public Integer getNumber_of_tickets_free() {return number_of_tickets_free;}

    public void setNumber_of_tickets_free(Integer number_of_tickets_free) {this.number_of_tickets_free = number_of_tickets_free;}

    @Override
    public String toString() {
        return "theater [id=" + id + ", play_title=" + play_title +", the_name_of_the_cast=" + the_name_of_the_cast + ", play_date_and_time=" + play_date_and_time + ", number_of_tickets=" + number_of_tickets + ", number_of_tickets_free=" + number_of_tickets_free +"]";
    }
}
