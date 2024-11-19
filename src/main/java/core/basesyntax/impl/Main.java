package core.basesyntax.impl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        storage.put(22,"XAX");
        storage.put(45,"Yea");
        storage.put(78,"KEK");
        System.out.println( storage.get(22));;
    }
}
