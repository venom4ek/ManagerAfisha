package ru.netology.manager;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.netology.domain.PurchaseItem;
import ru.netology.layers.PosterManager;
import ru.netology.layers.PosterRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class PosterManagerWithMockTest {
    @Mock
    private PosterRepository repository;

    @InjectMocks
    private PosterManager manager;

    private PurchaseItem film1 = new PurchaseItem(1, 101, "Операция Ы", "Комедия", "http1");
    private PurchaseItem film2 = new PurchaseItem(2, 102, "Король Лев", "мультфильм", "http2");
    private PurchaseItem film3 = new PurchaseItem(3, 103, "Карты, Деньги, Два ствола", "боевик", "http3");
    private PurchaseItem film4 = new PurchaseItem(4, 104, "Назад в будущее", "фантастика", "http4");
    private PurchaseItem film5 = new PurchaseItem(5, 105, "Гладиатор", "боевик", "http5");
    private PurchaseItem film6 = new PurchaseItem(6, 106, "Интерстеллар", "фантастика", "http6");
    private PurchaseItem film7 = new PurchaseItem(7, 107, "Игры разума", "драмма", "http7");
    private PurchaseItem film8 = new PurchaseItem(8, 108, "Крестный отец", "криминал", "http8");
    private PurchaseItem film9 = new PurchaseItem(9, 109, "Леон", "триллер", "http9");
    private PurchaseItem film10 = new PurchaseItem(10, 111, "Паронормальное явление", "ужасы", "http10");
    private PurchaseItem film11 = new PurchaseItem(11, 112, "Паронормальное явление 2", "ужасы", "http11");
    private PurchaseItem film12 = new PurchaseItem(12, 113, "Иван Васильевич меняет профессию", "комедия", "http12");
    private PurchaseItem film13 = new PurchaseItem(13, 114, "Первый Мститель", "фантастика", "http13");
    private PurchaseItem film14 = new PurchaseItem(14, 115, "Планета обезън", "фантастика", "http14");


    @Test
    public void shouldGet10LastFilms() {
        PurchaseItem[] returned = new PurchaseItem[] {film14, film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3};
        doReturn(returned).when(repository).findAll();

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[] {film3, film4, film5, film6, film7, film8, film9, film10, film11, film12};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldGetLastFilmsMoreDefault() {
        PurchaseItem[] returned = new PurchaseItem[] {film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12, film13, film14};
        doReturn(returned).when(repository).findAll();

        manager.setLenCustom(12);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film14, film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldGetLastFilmsLessDefault() {
        PurchaseItem[] returned = new PurchaseItem[] {film1, film2, film3, film4, film5, film6, film7};
        doReturn(returned).when(repository).findAll();

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldGetLastFiveFilms() {
        PurchaseItem[] returned = new PurchaseItem[] {film1, film2, film3, film4, film5, film6, film7};
        doReturn(returned).when(repository).findAll();

        manager.setLenCustom(5);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldWhenLenMoreFilms() {
        PurchaseItem[] returned = new PurchaseItem[] {film1, film2, film3, film4, film5, film6, film7};
        doReturn(returned).when(repository).findAll();

        manager.setLenCustom(10);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
