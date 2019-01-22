package com.tpfilms.tpfilms.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="film")

public class Film implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title;

    private float duration;

    private int budget;

    private int revenue;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date release_date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_director")
    private Director director;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_category")
    private Category category;

    @OneToMany(mappedBy = "film", cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"id_casting", "film"})
    private List<Casting> casting = new ArrayList<Casting>();

    private String url_image;

    public Film() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Casting> getCasting() {
        return casting;
    }

    public void setCasting(List<Casting> casting) {
        this.casting = casting;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", release_date=" + release_date +
                ", director=" + director +
                ", category=" + category +
                ", casting=" + casting +
                ", url_image='" + url_image + '\'' +
                '}';
    }

}
