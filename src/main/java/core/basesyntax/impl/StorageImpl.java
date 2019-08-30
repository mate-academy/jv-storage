package core.basesyntax.impl;

import core.basesyntax.Storage;

import javax.swing.*;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private K[] key;
    private V[] value;
    private int SIZE = 0;
    private int CAPASITY = 15;

    StorageImpl() {
        key = (K[]) new Object[CAPASITY];
        value = (V[]) new Object[CAPASITY];
    }

    @Override
    public void put(K key, V value) {
        resize();
        this.key[SIZE] = key;
        this.value[SIZE] = value;
        SIZE++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (this.key[i] == key || this.key[i].equals(key)) {
                return (V) value[i];
            }
        }
        return null;
    }

    public void resize() {
        if(key.length > SIZE * 0.8d) {
            key = Arrays.copyOf(key, CAPASITY << 1);
            value = Arrays.copyOf(value, CAPASITY << 1);
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < key.length; i++) {
            str += key[i] + "" + value[i] + "\n";
        }
        return str;
    }
}

