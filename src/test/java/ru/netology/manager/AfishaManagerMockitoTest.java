package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    Film first = new Film(222, "K9", "Mockito");
    Film second = new Film(333, "K10", "Mockito");
    Film third = new Film(444, "K11", "Mockito");

    @Test
    void shouldAddFilmWithMock() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addFilm(third);
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}