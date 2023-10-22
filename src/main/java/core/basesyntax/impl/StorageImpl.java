package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] arrOfPair = new Pair[MAX_ITEMS_NUMBER];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        int elementIndex = getIndexOfElement(key);
        if (elementIndex == -1) {
            for (int i = 0; i < arrOfPair.length; i++) {
                if (arrOfPair[i] == null) {
                    arrOfPair[i] = new Pair<>(key, value);
                    size++;
                    break;
                }
            }
        } else {
            arrOfPair[elementIndex].setValue(pair.getValue());
        }

    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < arrOfPair.length; i++) {
            if (i == size) {
                break;
            }
            if (Objects.equals(arrOfPair[i].getKey(), key)) {
                result = arrOfPair[i].getValue();
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndexOfElement(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arrOfPair[i] != null && Objects.equals(arrOfPair[i].getKey(), key)) {
                index = i;
                break;
            }
        }
        return index;

    }
}
