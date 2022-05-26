package com.example.mymobileproject.database.enteties;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favourites")
public class Favourites {

    @PrimaryKey
    public int id;
    public String img, title;

    public Favourites(int id, String img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Favourites{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
