package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int FIRST_NUMBER_FOR_ARRAY = 10;
    private static final int SECOND_NUMBER_FOR_ARRAY = 2;
    private static final int POSITION_KEY = 0;
    private static final int POSITION_VALUE = 1;
    private int counter;
    private final Object[][] arrayStorage;

    public StorageImpl() {
        arrayStorage =
                new Object[FIRST_NUMBER_FOR_ARRAY][SECOND_NUMBER_FOR_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if ((arrayStorage[i][POSITION_KEY] == key)
                    || (key != null && key.equals(arrayStorage[i][POSITION_KEY]))) {
                arrayStorage[i][POSITION_VALUE] = value;
                return;
            }
        }
        arrayStorage[counter][POSITION_KEY] = key;
        arrayStorage[counter][POSITION_VALUE] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == arrayStorage[i][POSITION_KEY]
                    || (key != null && key.equals(arrayStorage[i][POSITION_KEY]))) {
                return (V) arrayStorage[i][POSITION_VALUE];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
