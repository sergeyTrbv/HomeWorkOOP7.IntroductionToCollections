import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();                      //Метод "рандом"
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {

        Queue<String> queue1 = new ArrayDeque<>();                                              //Очередь в первую кассу
        Queue<String> queue2 = new ArrayDeque<>();                                             //Очередб во вторую кассу
        randomFilling(queue1);            //Вызываем метод рандомного заполнения очереди1
        randomFilling(queue2);            //Вызываем метод рандомного заполнения очереди2
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println(" ");

        add("Владимир Петров", queue1, queue2);

        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println(" ");

        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
    }

    private static void add(String name,                                 //Метод проверяющий где меньше людей в очереди
                            Queue<String> queue1,
                            Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("ГАЛЯЯЯ!");
            return;
        }

        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove(Queue<String> queue1,           //Метод удаляющий человека из случайной очереди
                               Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static final List<String> NAMES = List.of(                                                     //Список имён
            "Иван Иванович",
            "Сергеева Мария",
            "Титов Михаил",
            "Толкачев Али",
            "Герасимов Георгий",
            "Кузнецов Владимир",
            "Панов Платон",
            "Еремеев Александр",
            "Попова Варвара",
            "Романова Мария",
            "Соколова Кира"
    );

    private static void randomFilling(Queue<String> queue) {       //Метод случайного заполнения очереди, принимает очередь
        int size = RANDOM.nextInt(MAX_SIZE + 1);                        //Чтобы получить 5 элементов
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }


}