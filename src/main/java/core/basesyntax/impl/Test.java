package core.basesyntax.impl;

public class Test {
    public static void main(String[] args) {
        StorageImpl<String,Integer> str = new StorageImpl<>();
        str.put("FrstKey",2);
        System.out.println("size: " + str.size());
    }
}
