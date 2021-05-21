package core.basesyntax;

import core.basesyntax.impl.StorageImpl;
import org.junit.Assert;
import org.junit.Test;

public class StorageImplTest {

    @Test
    public void checkSizeIsNonStatic() {
        Storage<Integer, String> firstInstance = new StorageImpl<>();
        firstInstance.put(1, "Element 1");
        firstInstance.put(2, "Element 2");
        firstInstance.put(3, "Element 3");

        Assert.assertEquals("With three elements added to the storage, its size should be 3",
              3, firstInstance.size());

        Storage<Integer, String> secondInstances = new StorageImpl<>();

        Assert.assertEquals("After creating second empty storage instance its' size should be 0",
              0, secondInstances.size());
    }

    @Test
    public void addElementsToStorage() {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        String elementFour = "Element 4";
        String elementFive = "Element 5";
        String elementSix = "Element 6";
        String elementSeven = "Element 7";
        String elementEight = "Element 8";
        String elementNine = "Element 9";

        storage.put(1, elementOne);
        storage.put(2, elementTwo);
        storage.put(3, elementTree);
        storage.put(4, elementFour);
        storage.put(5, elementFive);
        storage.put(6, elementSix);
        storage.put(7, elementSeven);
        storage.put(8, elementEight);
        storage.put(9, elementNine);

        Assert.assertEquals("With three elements added to the storage, its size should be 3",
                9, storage.size());
        Assert.assertEquals(elementOne, storage.get(1));
        Assert.assertEquals(elementTwo, storage.get(2));
        Assert.assertEquals(elementTree, storage.get(3));
    }

    @Test
    public void getElementWhenKeyDontExist() {
        Storage<Integer, String> storage = new StorageImpl<>();

        Assert.assertNull(
                "When element with this key doesn't exist, the method should return \"null\"",
                storage.get(1234321));
    }

    @Test
    public void getElementWithKeyNull() {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        String elementFour = "Element 4";
        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(3, elementTree);
        storage.put(4, elementFour);
        Assert.assertEquals(
                "Test failed! Method get(null) should return value",
                elementTwo,
                storage.get(null));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementOne,
                storage.get(1));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementTree,
                storage.get(3));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementFour,
                storage.get(4));
    }

    @Test
    public void getElementWhenKeyIsObject() {
        Storage<Cat, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        String elementFour = "Element 4";
        String elementFive = "Element 5";
        String elementSix = "Element 6";
        String elementSeven = "Element 7";
        String elementEight = "Element 8";
        String elementNine = "Element 9";
        Cat firstCat = new Cat("Myrchyk", "white");
        Cat secondCat = new Cat("Barsik", "black");
        Cat thirdCat = new Cat("Barmaley", "red");
        Cat foursCat = new Cat("Musia", "yellow");
        Cat fivesCat = new Cat("Pusia", "orange");
        Cat sixthCat = new Cat("Dusia", "green");
        Cat sevensCat = new Cat("Zusia", "grey");
        Cat eightsCat = new Cat("Crista", "transperent");
        Cat ninthCat = new Cat("Selma", "hot");
        storage.put(firstCat, elementOne);
        storage.put(secondCat, elementTwo);
        storage.put(thirdCat, elementTree);
        storage.put(foursCat, elementFour);
        storage.put(fivesCat, elementFive);
        storage.put(sixthCat, elementSix);
        storage.put(sevensCat, elementSeven);
        storage.put(eightsCat, elementEight);
        storage.put(ninthCat, elementNine);
        System.out.println(storage.get(firstCat));
        System.out.println(storage.get(secondCat));
        System.out.println(storage.get(thirdCat));
        System.out.println(storage.get(foursCat));
        System.out.println(storage.get(fivesCat));
        System.out.println(storage.get(sixthCat));
        System.out.println(storage.get(sevensCat));
        System.out.println(storage.get(eightsCat));
        System.out.println(storage.get(ninthCat));
        Cat sameSecondCat = new Cat("Barsik", "black");

        Assert.assertEquals(
                "Test failed! Method get(key) should return correct value",
                elementTwo, storage.get(sameSecondCat));
    }

    @Test
    public void addTwoElementsWithSameKey() {
        Storage<Cat, String> storage = new StorageImpl<>();
        Cat cat = new Cat("Myrchyk", "white");
        Cat sameCat = new Cat("Myrchyk", "white");
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(cat, elementOne);
        storage.put(sameCat, elementTwo);

        Assert.assertEquals(
                "With two elements added with the same key, "
                        + "the value should be rewritten",
                elementTwo,
                storage.get(cat));
        Assert.assertEquals("With two elements added with the same key, "
                        + "the storage size should be 1",
                1, storage.size());
    }

    @Test
    public void addTwoElementsWithNullKey() {
        Storage<Cat, String> storage = new StorageImpl<>();
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(null, elementOne);
        storage.put(null, elementTwo);

        Assert.assertEquals(
                "With two elements added with the same \"null\" key, "
                        + "the value should be rewritten",
                elementTwo,
                storage.get(null));
        Assert.assertEquals("With two elements added with the same \"null\" key, "
                        + "the storage size should be 1",
                1, storage.size());
    }
}
