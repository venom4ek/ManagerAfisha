package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {
 //   private PosterRepository repository;
    PosterManager manager = new PosterManager();
     PurchaseItem film1 = new PurchaseItem(1, 101, "Операция Ы", "Комедия", "http1");
     PurchaseItem film2 = new PurchaseItem(2, 102, "Король Лев", "мультфильм", "http2");
     PurchaseItem film3 = new PurchaseItem(3, 103, "Карты, Деньги, Два ствола", "боевик", "http3");
     PurchaseItem film4 = new PurchaseItem(4, 104, "Назад в будущее", "фантастика", "http4");
     PurchaseItem film5 = new PurchaseItem(5, 105, "Гладиатор", "боевик", "http5");
     PurchaseItem film6 = new PurchaseItem(6, 106, "Интерстеллар", "фантастика", "http6");
     PurchaseItem film7 = new PurchaseItem(7, 107, "Игры разума", "драмма", "http7");
     PurchaseItem film8 = new PurchaseItem(8, 108, "Крестный отец", "криминал", "http8");
     PurchaseItem film9 = new PurchaseItem(9, 109, "Леон", "триллер", "http9");
     PurchaseItem film10 = new PurchaseItem(10, 111, "Паронормальное явление", "ужасы", "http10");
     PurchaseItem film11 = new PurchaseItem(11, 112, "Паронормальное явление 2", "ужасы", "http11");
     PurchaseItem film12 = new PurchaseItem(12, 113, "Иван Васильевич меняет профессию", "комедия", "http12");
     PurchaseItem film13 = new PurchaseItem(13, 114, "Первый Мститель", "фантастика", "http13");
     PurchaseItem film14 = new PurchaseItem(14, 115, "Планета обезън", "фантастика", "http14");

    @BeforeEach
    public void manageAdd() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
    }

    @Test
    public void shouldGet10LastFilms() {
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        manager.add(film12);
        manager.add(film13);
        manager.add(film14);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film14, film13, film12, film11, film10, film9, film8, film7, film6, film5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsMoreDefault() {
        manager.setLenCustom(12);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        manager.add(film12);
        manager.add(film13);
        manager.add(film14);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film14, film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsLessDefault() {
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetLastFiveFilms() {
        manager.setLenCustom(5);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWhenLenMoreFilm() {
        manager.setLenCustom(10);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(expected, actual);
    }
}
