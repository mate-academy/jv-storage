package core.basesyntax;

import core.basesyntax.impl.Box;
import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, Box> storage = new StorageImpl<>();
        Box box1 = new Box("box1", 453);
        storage.put(22, box1);
        Box outputBox1 = storage.get(22);

        Box box2 = new Box("box2", 534);
        storage.put(22, box2);
        Box outputBox2 = storage.get(32);

        System.out.println(outputBox2);
        System.out.println(storage.size());

    }
}
