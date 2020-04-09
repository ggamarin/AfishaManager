package ru.netology.repository;

import ru.netology.domain.Film;

public class AfishaRepository {
    private Film[] films = {
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

    public Film[] findAll() {
        return films;
    }

    public void save(Film film) {
        Film[] tmpArray = new Film[films.length + 1];
        System.arraycopy(films, 0, tmpArray, 0, films.length);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = film;
        films = tmpArray;
    }

    public Film findById(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    void removeById(int id) {
        int length = films.length - 1;
        Film[] tmpArray = new Film[length];
        int i = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmpArray[i] = film;
                i++;
            }
        }
        films = tmpArray;
    }

    void removeAll() {
        films = new Film[0];
    }
}
