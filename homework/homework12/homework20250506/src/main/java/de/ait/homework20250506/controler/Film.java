package de.ait.homework20250506.controler;

public class Film {
    public String title;
    public String director;

    public Film() {
    }

    public Film(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
