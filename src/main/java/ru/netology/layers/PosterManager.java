package ru.netology.layers;

import lombok.Data;
import ru.netology.domain.PurchaseItem;
import org.jetbrains.annotations.TestOnly;
import ru.netology.layers.PosterRepository;

@Data
public class PosterManager {
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.add(item);
    }

    private int defaultLength = 10;
    private int lenCustom = 0;

    public int setLen(int itemsSize) {
        int len = defaultLength;
        if (lenCustom == 0 || lenCustom > itemsSize) {
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
        int resultSize = setLen(items.length);
        PurchaseItem[] result = new PurchaseItem[resultSize];
        for (int i = 0; i < resultSize; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
