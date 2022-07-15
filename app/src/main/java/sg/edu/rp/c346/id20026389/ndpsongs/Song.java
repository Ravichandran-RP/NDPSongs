package sg.edu.rp.c346.id20026389.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {
    private 	int id;
    private 	String title;
    private 	int year;
    private 	String singers;
    private 	int stars;

    public int getYear() {
        return year;
    }

    public String getSingers() {
        return singers;
    }

    public int getStars() {
        return stars;
    }

    public int getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }

    public Song(int id,String title,String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.singers = singers;
        this.stars = stars;
    }

}
