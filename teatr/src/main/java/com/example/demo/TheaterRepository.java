package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    @Query("SELECT p FROM Theater p WHERE CONCAT(p.play_title, ' ', p.the_name_of_the_cast, ' ', p.play_date_and_time, ' ', p.number_of_tickets, ' ', p.number_of_tickets_free) LIKE %?1%")
    List<Theater> search(String keyword);

    @Query("select cast(count(id) / count(distinct play_date_and_time) as float) as amount FROM Theater")
    Float avgPerDay();

    @Query("select play_date_and_time, count(play_date_and_time) as amount from Theater group by play_date_and_time")
    List<String> amount();
}
