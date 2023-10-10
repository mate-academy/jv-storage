package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Pair[] content;

    public StorageImpl() {
        this.content = new Pair[0];
    }

    private int findKeysIndex(K key) {
        for (int i = 0; i < content.length; i++) {
            Object oldKey = content[i].getKey();
            boolean firstCondition = (oldKey == null && key == null);
            boolean secondCondition = (key != null && key.equals(oldKey));
            if (firstCondition || secondCondition) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = findKeysIndex(key);
        if (keyIndex >= 0) {
            content[keyIndex] = new Pair(key, value);
            return;
        }
        if (content.length < MAX_STORAGE_SIZE) {
            int newLength = content.length + 1;
            this.content = Arrays.copyOf(content, newLength);
            content[newLength - 1] = new Pair(key, value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeysIndex(key);
        if (keyIndex == -1) {
            return null;
        }
        return (V) content[keyIndex].getValue();
    }

    @Override
    public int size() {
        return content.length;
    }
}
