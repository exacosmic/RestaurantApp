package com.restaurant.app.models;

/**
 * User feedback or comment.
 */
public class FeedbackItem {
    private final float rating;
    private final String comment;

    public FeedbackItem(float rating, String comment) {
        this.rating = rating;
        this.comment = comment != null ? comment : "";
    }

    public float getRating() { return rating; }
    public String getComment() { return comment; }
}
