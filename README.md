# jv-storage

Implement the `Storage` of `key-value` type that is parameterized with two types of data. 
You should be able to put new key-value pair and to get value by key.

If you are given the key-value pair, and the storage already contains this key, you should replace the value.

Example:
```java
Storage<Integer, Box> storage = new StorageImpl<>(); 
Box box = new Box();
storage.put(22, box); 
Box value = storage.get(22); // returns the Box
int size = storage.size(); // returns storage size
```
You should solve this task using one or two arrays (this depends on your implementation). 
If you use arrays for your solution, we assume that the maximum number of elements in our `Storage` is 10.
#### [Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/generics/storage.html)
Реалізуйте "Сховище" типу "ключ-значення", яке параметризовано двома типами даних.
Ви повинні мати можливість помістити нову пару ключ-значення та отримати значення за ключем.

Якщо вам надано пару ключ-значення, а сховище вже містить цей ключ, слід замінити значення.

приклад:
```java
Storage<Integer, Box> storage = new StorageImpl<>();
Box box = new Box();
storage.put(22, box);
Значення ящика = storage.get(22); // повертає Box
int size = storage.size(); // повертає розмір пам'яті
```
Ви повинні вирішити це завдання, використовуючи один або два масиви (це залежить від вашої реалізації).
Якщо ви використовуєте масиви для свого рішення, ми припускаємо, що максимальна кількість елементів у нашому `Storage` дорівнює 10.