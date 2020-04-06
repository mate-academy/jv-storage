package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static Object[][] o = new Object[10][2];
    private static int i = 0;

    @Override
    public void put(K key, V value) {
        for (int j = 0; j < i; j++) {
            if ((key == null && o[j][0] == null) || (o[j][0] != null && o[j][0].equals(key))) {
                o[j][1] = value;
                return;
            }
        }
        o[i][0] = key;
        o[i][1] = value;
        i++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < i; j++) {
            if ((key == null && o[j][0] == null) || (o[j][0] != null && o[j][0].equals(key))) {
                return (V) (o[j][1]);
            }
        }
        return null;
    }
}
