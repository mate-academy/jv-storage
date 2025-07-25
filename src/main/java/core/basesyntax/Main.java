package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>("black");
        System.out.println(box); // Box{value=black}

        box.setValue("white");
        System.out.println(box.getValue()); // white
    }
}


