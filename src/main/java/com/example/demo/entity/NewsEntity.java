package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "news")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "title",length = 100)
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "content")
    private String content;
    @Column(name = "dateUpdate")
    private String dateUpdate;
    @Column(name = "categoryId")
    private  int categoryId;
    @Column(name = "post",columnDefinition = "text")
    private String post;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public NewsEntity(Long id, String title, String image, String content, String dateUpdate, int categoryId, String post) {
        Id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.dateUpdate = dateUpdate;
        this.categoryId = categoryId;
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public NewsEntity() {
    }
}
