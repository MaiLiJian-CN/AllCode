package com.yichen.bean;

import java.util.Date;

public class MovieDemo {
    private String movie_name;
    private String actor;
    private Double score;
    private Double time;
    private Double price;
    private int number;
    private Date startTime;

    public MovieDemo(String movie_name, String actor, Double time, Double price, int number, Date startTime) {
        this.movie_name = movie_name;
        this.actor = actor;
        this.time = time;
        this.price = price;
        this.number = number;
        this.startTime = startTime;
    }

    public MovieDemo() {
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
