package book;

import java.io.File;
import java.util.Random;

public class Book {

    static String FILE_PATH = System.getProperty("user.dir") +
            File.separator + "src" + File.separator + "book" +File.separator + "book.txt";

    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        BookWriter writer = new BookWriter(FILE_PATH, locker);
        BookReader reader = new BookReader(FILE_PATH, locker);
        Thread thread1 = new Thread(writer);
        Thread thread2 = new Thread(writer);
        Thread thread3 = new Thread(reader);
        Thread thread4 = new Thread(reader);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        while (true) {
            int a = random.nextInt(3);

            thread1.join(a * 1000);
            thread2.join(a * 1000);

        }

    }
}
