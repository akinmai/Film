package com.company;

import java.util.List;

    public class Film {
        String title;
        double rating;

        public Film(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public double getRating() {
            return rating;
        }



        @Override
        public String toString() {
            return "Movie title: " + title + ", " + "rating: " + rating + ".";
        }


    }



