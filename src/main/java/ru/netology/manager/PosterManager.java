package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.PurchaseItem;

@Data
public class PosterManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int defaultLength = 10;
    private int lenCustom = 0;

    public PosterManager() {
    }

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public int setLen() {
        int len = defaultLength;
        if (lenCustom == 0 || lenCustom > items.length) {
            if (len > items.length) {
                len = items.length;
            }
            return len;
        }
        len = lenCustom;
        return len;
    }

    public PurchaseItem[] getFilm() {
        PurchaseItem[] result = new PurchaseItem[setLen()];
        for (int i = 0; i < setLen(); i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
