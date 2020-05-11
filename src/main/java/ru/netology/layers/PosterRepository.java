package ru.netology.layers;

import lombok.Data;
import ru.netology.domain.PurchaseItem;
import ru.netology.layers.PosterManager;

@Data
public class PosterRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public PosterRepository() {
    }

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void findById(int id) {
        int index = 0;
        PurchaseItem[] tmp = new PurchaseItem[1];
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        PurchaseItem[] tmp = new PurchaseItem[0];
        items = tmp;
    }

}
