package core.basesyntax.impl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> test = new StorageImpl<>();
        test.put(10, "test1");
        test.put(1, "test2");

        System.out.println(test.get(1));
        System.out.println(test.get(10));
    }
}
