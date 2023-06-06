
import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

//создать remove - удаление элементов, возвращает boolean
//создать contains - содержится ли элемент в списке, но не удаляет, возвращает boolean
public class remove_add_contains_String {
    public static void main(String[] args) {
        MySet<Integer> numbers = new MySet<>();    //конструктор
        //в MySet  - будем описывать, как будут храниться наши объекты
        for (int i = 0; i < 10; i++) {
            numbers.addNum(new Random().nextInt(10));   //рандомный объект до 100  //синтаксис анонимного объекта
        }


//        for (int i = 0; i < 10; i++) {     //вариант записи для remove
//            System.out.println(numbers.remove(new Random().nextInt(10)));


//        for (int i = 0; i < 10; i++) {      //вариант записи для contains
//            System.out.println(numbers.contains(new Random().nextInt(10)));
//        }    //возвращает истину-ложь. ложь-если нет ключа в списке


        Iterator<Integer> iter = numbers.iterator();    //вариант записи для метода toString
        while (iter.hasNext()) {             //пробегаемся
            int a = iter.next();            //вводим а
            if (a % 2 == 0) {                   //выводим только то, что кратно 2
                System.out.println(a);
            }
        }
        System.out.println(numbers);
    }

    static class MySet<T> {    //T  - это дженерик вместо integer (синтаксический сахар, ничего особо не делает)
        //private - внутрянка, чтобы пользователь не видел
        //private HashMap <T, Object> myMap = new HashMap<>(); - так было изначально, затем измении на строчку ниже
        private final HashMap<T, Object> myMap = new HashMap<>();   //HashMap - так как н сам проверяет, чтобы не было повторений
        private static final Object MYOBJECT = new Object();       //создаем финализированный объект, чтобы ссылаться на него(он приватный). если константа - то полностью большими буквами

        public void addNum(T i) {     //чтобы можно было добавлять объекты

            myMap.put(i, MYOBJECT);
        }


        //remove - удаление элементов, возвращает boolean
        //public boolean remove(T i) {

        //return myMap.remove(i) == MYOBJECT;
        //       }


        //contains - проверка на наличие по ключу, возвращает boolean
        //public boolean contains(T i) {

        //return myMap.containsKey(i);
        //}


//переопределяем toString для нашего MySet, ничего не принимает, а возвращает строку. Т.е. наши мэпы превращаем в значения?

        @Override      //@ указывает, то мы этот метод унаследовали, а не сами придумали
        public String toString() {

            StringBuilder str = new StringBuilder("[");     //создали Стрингбилдер
            Iterator<T> iter = myMap.keySet().iterator();    //пробегаемся итератором по Мапу

            while (iter.hasNext()) {
                str.append(iter.next() + ",");        //добавляем эл-ты через запятую
            }
            str.append("]");
            return str.toString();
        }


        //создаем метод, который будет возвращать ключи нашего Мапа, вывести на экран только %2
        public Iterator<T> iterator() {
            return myMap.keySet().iterator();
        }
    }
}




