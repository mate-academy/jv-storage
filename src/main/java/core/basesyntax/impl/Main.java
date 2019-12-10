package core.basesyntax.impl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> test = new StorageImpl<>();
        test.put(10, "test1");
        test.put(null, "test2");
        test.put(121, "test3");

        System.out.println(test.get(121));
        System.out.println(test.get(10));
        System.out.println(test.get(null));
    }
}
