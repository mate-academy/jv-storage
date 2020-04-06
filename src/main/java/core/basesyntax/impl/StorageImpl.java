package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys;
    private V[] values;
    private K[] keysTemp;
    private V[] valuesTemp;
    private int elementsK = 0;
    private int elementsV = 0;

    @Override
    public void put(K key, V value) {
        if (elementsK == 0) {
            createBox();
            keys[elementsK] = key;
            elementsK++;
            values[elementsV] = value;
            elementsV++;
        } else if (elementsK < keys.length) {
            reviewKey(key, value);
            keys[elementsK] = key;
            elementsK++;
            values[elementsV] = value;
            elementsV++;
        } else {
            reviewKey(key, value);
            doobleBox();
            keys[elementsK] = key;
            elementsK++;
            values[elementsV] = value;
            elementsV++;
        }
    }

    @Override
    public V get(K key) {
        V needed = null;
        int match = 0;
        if (elementsK > 0) {
            elementsK--;
            elementsV--;
            for (int i = 0; i < values.length; i++) {
                if (key != null ? keys[i].equals(key) : keys[i] == key) {
                    needed = values[i];
                    match = i;
                    break;
                }
            }
            for (int i = match; i < keys.length - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
        }
        return needed;
    }

    private void createBox() {
        keys = (K[]) new Object[2];
        values = (V[]) new Object[2];
    }

    private void doobleBox() {
        keysTemp = keys;
        valuesTemp = values;
        keys = (K[]) new Object[keys.length * 2];
        values = (V[]) new Object[values.length * 2];
        for (int i = 0; i < keysTemp.length; i++) {
            keys[i] = keysTemp[i];
            values[i] = valuesTemp[i];
        }
    }

    private void reviewKey(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                values[i] = value;
                break;
            }
        }
    }
}
