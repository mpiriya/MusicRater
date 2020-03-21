public class Song {
    private String title;
    private String artist;
    private String album;
    private Integer duration; //seconds
    private Integer rating; //0-10
    //possible additions: album image?

    public Song(String title, String artist, String album, Integer duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.rating = 0;
    }

    public Song(String title, String artist, Integer duration) {
        this(title, artist, "(unknown)", duration);
    }

    public Song(String title, Integer duration) {
        this(title, "(unknown)", "(unknown)", duration);
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

    public String toString() {
        return title + " (" + duration + ") by " + artist + " Album: " + album; 
    }

    public String title() {
        return this.title;
    }

    public String artist() {
        return this.artist;
    }

    public String album() {
        return this.album;
    }

    public Integer duration() {
        return this.duration;
    }

    public Integer rating() {
        return this.rating;
    }

    public void setartist(String artist) {
        this.artist = artist;
    }

    public void setalbum(String album) {
        this.album = album;
    }

    public void setrating(Integer rating) {
        this.rating = rating;
    }
}