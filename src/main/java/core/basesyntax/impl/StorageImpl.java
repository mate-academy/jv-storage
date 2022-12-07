package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Element[] elements;
    private int size;

    public StorageImpl(){
        elements = new Element[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].getKey() == key
                    || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                elements[i].setValue(value);
                return;
            }
        }
        Element element = new Element(key, value);
        elements[size] = element;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (elements[i].getKey() == key
                    || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                return (V) elements[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Element<K, V> {
    private K key;
    private V value;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

