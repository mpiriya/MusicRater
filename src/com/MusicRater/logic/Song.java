package src.com.MusicRater.logic;

public class Song {
    private String title;
    private String artist;
    private Integer rating; //0-10
    //possible additions: album image?

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.rating = 0;
    }

    public Song(String title) {
        this(title, "(unknown)");
    }

    public void increaseRating() {
        if(rating <= 10) {
            rating++;
        }
        else {
            //display error "Cannot push rating past 10"
        }
    }

    public void decreaseRating() {
        if(rating > 0) {
            rating--;
        } else {
            //display error "Cannot push rating below 0"
        }
    }

    public String[] toStringArray() {
        String[] toReturn = {title, artist, Integer.toString(rating)};
        return toReturn;
    }

    public String toString() {
        return title + " by " + artist;
    }

    public String title() {
        return this.title;
    }

    public String artist() {
        return this.artist;
    }

    public Integer rating() {
        return this.rating;
    }

    public void setrating(Integer rating) {
        this.rating = rating;
    }
}