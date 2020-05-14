package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    private PosterRepository repository;

    private int defaultLength = 10;
    private int lenCustom = 0;

    public PosterManager(int lenCustom) {
        this.lenCustom = lenCustom;
    }

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.add(item);
    }

    public int setLength(int itemsSize) {
        int len = defaultLength;
        if (lenCustom <= 0 || lenCustom > itemsSize) {
            if (len > itemsSize) {
                len = itemsSize;
            }
            return len;
        }
        len = lenCustom;
        return len;
    }

    public PurchaseItem[] getFilm() {
        PurchaseItem[] items = repository.findAll();
        int resultSize = setLength(items.length);
        PurchaseItem[] result = new PurchaseItem[resultSize];
        for (int i = 0; i < resultSize; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
