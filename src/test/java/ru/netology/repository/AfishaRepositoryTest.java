package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Film filmToAdd = new Film(33, "Dunkerk", "action");

    @BeforeEach
    void setUp(){
        repository.save(filmToAdd);
    }

    @Test
    void shouldFindAll() {
        Film[] actual = repository.findAll();
        Film[] expected = {
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
                new Film(12, "Up", "cartoon"),
                new Film(33, "Dunkerk", "action")
        };
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldSave() {
        Film filmToAdd = new Film(14, "Room 1408", "horror");
        repository.save(filmToAdd);
        Film[] actual = repository.findAll();
        Film[] expected = {
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
                new Film(12, "Up", "cartoon"),
                new Film(33, "Dunkerk", "action"),
                new Film(14, "Room 1408", "horror")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Film actual = repository.findById(33);
        Film expected = new Film(33, "Dunkerk", "action");
        assertEquals(expected,actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(33);
        Film[] actual = repository.findAll();
        Film[] expected = {
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
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Film[] expected ={};
        Film[] actual =repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveByNotExistId(){
        repository.removeById(7);
        Film[] expected = {
                new Film(1, "Bloodshot", "action"),
                new Film(2, "The Gentlemen", "action"),
                new Film(3, "Invisible Man", "horror"),
                new Film(4, "Number One", "comedy"),
                new Film(5, "Interstellar", "sci-fi")
        };
        Film[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
        }
    }
