package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class PosterManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int defaultLength = 10;
    private int lenCustom = 0;

    public PosterManager() {
    }

    public PosterManager(int lenCustom) {
        this.lenCustom = lenCustom;
    }

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
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
        PurchaseItem[] result = new PurchaseItem[setLength(items.length)];
        int resultSize = setLength(items.length);
        for (int i = 0; i < resultSize; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
