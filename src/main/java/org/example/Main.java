package org.example;
import java.util.HashMap;
import java.util.Random;


//задание - изобразить работу HashSet-а; придумать, как будут храниться данные
//MySet - это МЭП, но без ключей, без повторений элементов, это обертка вокруг МЭП
//надо создать свой класс (у меня - MySet)
public class Main {
    public static void main(String[] args) {
        MySet <Integer> numbers = new MySet<>();    //конструктор
        //в MySet  - будем описывать, как будут храниться наши объекты
        for (int i = 0; i<10;i++) {
            numbers.addNum(new Random().nextInt(10));   //рандомный объект до 100  //синтаксис анонимного объекта

            System.out.println(numbers);    //красный кружок - точка останова
            //HashSet<Integer> a = new HashSet<>();

        }
    }
}
class MySet <T> {    //T  - это дженерик вместо integer (синтаксический сахар, ничего особо не делает)
    //private - внутрянка, чтобы пользователь не видел
    //private HashMap <T, Object> myMap = new HashMap<>(); - так было изначально, затем измении на строчку ниже
    private final HashMap<T, Object> myMap = new HashMap<>();   //HashMap - так как н сам проверяет, чтобы не было повторений
    private static final Object MYOBJECT = new Object();       //создаем финализированный объект, чтобы ссылаться на него(он приватный). если константа - то полностью большими буквами

    public void addNum(T i) {     //чтобы можно было добавлять объекты

        myMap.put(i, MYOBJECT);
    }
}





