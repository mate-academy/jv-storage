# jv-array-list

Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя 
типами данных, и в этом хранилище можо класть значение по ключу и 
доставать значение по ключу. 
Пример: 
Storage<Integer, Box> storage = new Storage<>(); 
storage.put(22, box); 
storage.get(22) // вернёт коробку.
