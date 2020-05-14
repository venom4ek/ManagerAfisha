package ru.netology.repository;

import lombok.Data;
import ru.netology.domain.PurchaseItem;

@Data
public class PosterRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

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

        public void removeById ( int id){
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


    public PurchaseItem[] findById(int id) {
        int index = 0;
        PurchaseItem[] tmp = new PurchaseItem[1];
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
            }
        }
        items = tmp;
        return items;
    }

    public void removeAll() {
        PurchaseItem[] tmp = new PurchaseItem[0];
        items = tmp;
    }

}
