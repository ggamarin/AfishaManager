package ru.netology.domain;

public class AfishaManager {
    Film[] films = {
            new Film(1, "Bloodshot", "action"),
            new Film(2, "The Gentlemen", "action"),
            new Film(3, "Invisible Man", "horror"),
            new Film(4, "Number One", "comedy"),
            new Film(5, "Interstellar", "sci-fi"),
            new Film(6, "Midsommar", "thriller"),
            new Film(7, "Onward", "cartoon"),
            new Film(8, "Terminator2", "action/sci-fi"),
            new Film(9, "Hotel Belgrad", "comedy"),
            new Film(10, "Joker", "tragedy"),
            new Film(11, "Isle of dogs", "cartoon"),
            new Film(12, "Up", "cartoon")
    };


    public void addFilm(Film film) {
        int filmsLength = films.length;
        Film[] tmpArray = new Film[filmsLength + 1];
        System.arraycopy(films, 0, tmpArray, 0, filmsLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = film;
        films = tmpArray;
    }

    public Film[] getLastAdded(int howManyFilmsToShow) {
        int filmsLength = films.length;
        int showMax = 10;
        if (howManyFilmsToShow <= 0 || howManyFilmsToShow > showMax) {
            howManyFilmsToShow = showMax;
        }
        if (showMax > filmsLength) {
            showMax = filmsLength;
        }
        if (howManyFilmsToShow <= showMax) {
            showMax = howManyFilmsToShow;
        } else {
            showMax = filmsLength;
        }
        Film[] customFilm = new Film[showMax];
        for (int current = 0; current < customFilm.length; current++) {
            int result = filmsLength - current - 1;
            customFilm[current] = films[result];
        }
        return customFilm;
    }
}


