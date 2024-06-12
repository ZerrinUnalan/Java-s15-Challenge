package model;

public class CommentRating {
    private int rating;
    private String comment;

    public CommentRating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }


    @Override
    public String toString() {
        return "CommentRating{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
