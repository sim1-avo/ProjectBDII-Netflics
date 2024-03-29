package model;
public class Film {
    @Override
  public String toString() {
    return "Film [show_id=" + show_id + ", type=" + type + ", title=" + title + ", director="
        + director + ", cast=" + cast + ", country=" + country + ", date=" + date
        + ", release_year=" + release_year + ", rating=" + rating + ", duration=" + duration
        + ", listed_in=" + listed_in + ", description=" + description + "]";
  }

    String show_id;
    String type;
    String title;
    String director;
    String cast;
    String country;
    String date;
    int release_year;
    String rating;
    String duration;
    String listed_in;
    String description;

    public Film(){
      this.release_year=0;
    }
    
    
    public Film(String show_id, String type, String title, String director, String cast,
        String country, String date, int release_year, String rating, String duration,
        String listed_in, String description) {
      super();
      this.show_id = show_id;
      this.type = type;
      this.title = title;
      this.director = director;
      this.cast = cast;
      this.country = country;
      this.date = date;
      this.release_year = release_year;
      this.rating = rating;
      this.duration = duration;
      this.listed_in = listed_in;
      this.description = description;
    }


    public Film(String show_id) {
        this.show_id = show_id;
        this.release_year=0;
    }

    public String getShow_id() {
        return show_id;
    }

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListed_in() {
        return listed_in;
    }

    public void setListed_in(String listed_in) {
        this.listed_in = listed_in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
