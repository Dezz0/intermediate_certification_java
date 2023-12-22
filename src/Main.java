// Main.java
public class Main {
    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue();

        toyQueue.put("1 2 конструктор");
        toyQueue.put("2 2 робот");
        toyQueue.put("3 6 кукла");

        toyQueue.processQueueAndWriteToFile();
    }
}
