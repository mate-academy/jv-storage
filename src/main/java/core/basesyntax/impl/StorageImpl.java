package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10; //фактичний розмір масиву
    private Object[] keysArr; //масив ключових слів
    private Object[] valuesArr; //масив значень
    private int lastArrayIndex; //кількість елементів у масиві

    public StorageImpl() {
        keysArr = new Object[MAX_ARRAY_LENGTH];
        valuesArr = new Object[MAX_ARRAY_LENGTH];
        lastArrayIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lastArrayIndex; i++) {
            if (keysArr[i] == key || keysArr[i] != null && keysArr[i].equals(key)) {
                //перевірка, чи є у масиві значення,
                // які ідентичні тим, що вказуе користувач
                valuesArr[i] = value;
                return;
            }
        }
        keysArr[lastArrayIndex] = key;
        valuesArr[lastArrayIndex] = value;
        lastArrayIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lastArrayIndex; i++) {
            if (keysArr[i] == key || keysArr[i] != null && keysArr[i].equals(key)) {
                //знаходження потрібного значення у масиві
                V searchResult = (V) valuesArr[i];
                return searchResult;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastArrayIndex;
        //кількість елементів у масиві
    }
}
