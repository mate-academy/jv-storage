package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final Element<K, V>[] elements = new Element[MAX_ELEMENTS_NUMBER];
    private int elementCounter = 0;

    @Override
    public void put(K key, V value) {
        Element<K, V> existingElement = findElementByKey(key);
        if (existingElement != null) {
            existingElement.setValue(value);
        } else {
            Element<K, V> element = new Element<>(key, value);
            elements[elementCounter] = element;
            elementCounter++;
        }
    }

    @Override
    public V get(K key) {
        Element<K, V> existingElement = findElementByKey(key);
        if (existingElement != null) {
            return existingElement.getValue();
        }
        return null;
    }

    private Element<K, V> findElementByKey(K key) {
        for (int i = 0; i < elementCounter; i++) {
            Element<K, V> existingElement = elements[i];
            if (Objects.equals(existingElement.getKey(), key)) {
                return existingElement;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementCounter;
    }
}
