package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Film filmToAdd = new Film(33, "Dunkerk", "action");
    private Film[] expected;

    @BeforeEach
    void setUp() {
        manager.addFilm(filmToAdd);
        expected = new Film[]{
                new Film(33, "Dunkerk", "action"),
                new Film(12, "Up", "cartoon"),
                new Film(11, "Isle of dogs", "cartoon"),
                new Film(10, "Joker", "tragedy"),
                new Film(9, "Hotel Belgrad", "comedy"),
                new Film(8, "Terminator2", "action/sci-fi"),
                new Film(7, "Onward", "cartoon"),
                new Film(6, "Midsommar", "thriller"),
                new Film(5, "Interstellar", "sci-fi"),
                new Film(4, "Number One", "comedy")
        };
    }

    @Test
    public void showAll() {
        Film[] actual = manager.getLastAdded(7);
        Film[] expected = {
                new Film(33, "Dunkerk", "action"),
                new Film(12, "Up", "cartoon"),
                new Film(11, "Isle of dogs", "cartoon"),
                new Film(10, "Joker", "tragedy"),
                new Film(9, "Hotel Belgrad", "comedy"),
                new Film(8, "Terminator2", "action/sci-fi"),
                new Film(7, "Onward", "cartoon")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showMoreThanMax() {
        Film[] actual = manager.getLastAdded(50);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showNothing() {
        Film[] actual = manager.getLastAdded(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showNegative() {
        Film[] actual = manager.getLastAdded(-1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showAboveMax() {
        Film[] actual = manager.getLastAdded(11);
        assertArrayEquals(expected, actual);
    }
}
