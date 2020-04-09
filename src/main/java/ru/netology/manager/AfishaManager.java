package ru.netology.manager;

import  lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;
import  lombok.Data;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaManager {
    private AfishaRepository repository = new AfishaRepository();

    public void addFilm(Film film) {
       repository.save(film);
    }

    public Film[] getLastAdded(int howManyFilmsToShow) {
        Film[] films = repository.findAll();
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

    public Film[] getAll(){
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}


