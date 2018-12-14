package com.tpfilms.tpfilms.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="film")

public class Film implements Serializable {

    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private float duration;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "budget")
    private int budget;

    @Column(name = "revenue")
    private int revenue;

    @OneToOne()
    @JoinColumn(name="id_director")
    private Director director;

    @OneToOne()
    @JoinColumn(name="id_category")
    private Category category;

    @OneToMany(mappedBy = "id_casting.film", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("film")
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
}
