package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private CustomNode<K, V>[] table = new CustomNode[0];

    @Override
    public void put(K key, V value) {
        CustomNode<K, V> inputNode = new CustomNode<>(key, value);

        if (table.length < MAX_CAPACITY) {
            for (int i = 0; i < table.length; i++) {
                if (Objects.equals(key, table[i].getKey())) {
                    table[i] = inputNode;
                    return;
                }
            }
            putValue(inputNode);
        } else {
            throw new RuntimeException("The array already full");
        }
    }

    public void putValue(CustomNode<K, V> inputNode) {
        CustomNode<K, V>[] tab;
        tab = Arrays.copyOf(table, table.length + 1);
        tab[tab.length - 1] = inputNode;
        table = Arrays.copyOf(tab, tab.length);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < table.length; i++) {
            if (Objects.equals(key, table[i].getKey())) {
                return table[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return table.length;
    }

    private static class CustomNode<K, V> {
        private final K key;
        private final V value;

        CustomNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }
    }
}
