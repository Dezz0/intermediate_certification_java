// ToyQueue.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyQueue {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getWeight(), t1.getWeight()));

    public void put(String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        String name = parts[2];

        // Добавим дополнительный параметр веса (частоты)
        int weight = 1; // Установим вес по умолчанию

        if (parts.length > 3) {
            // Если есть четвертая часть, то это вес
            weight = Integer.parseInt(parts[3]);
        }

        Toy toy = new Toy(id, name, weight);
        toyQueue.add(toy);
    }

    public String get() {
        double rand = Math.random();
        if (rand < 0.2) {
            return "1";
        } else if (rand < 0.4) {
            return "2";
        } else {
            return "3";
        }
    }

    public void processQueueAndWriteToFile() {
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = toyQueue.poll();
                if (toy != null) {
                    String result = get();
                    writer.write(result + " - " + toy.getId() + " " + toy.getName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
