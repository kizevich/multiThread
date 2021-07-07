package book;

import java.io.File;
import java.util.Random;

public class Book {

    static String FILE_PATH = System.getProperty("user.dir") +
            File.separator + "src" + File.separator + "book" +File.separator + "book.txt";

    static Random random = new Random();

    public static void main(String[] args) {
        Object locker = new Object();
        BookWriter writer = new BookWriter(FILE_PATH, locker);
        BookReader reader = new BookReader(FILE_PATH, locker);
        Thread thread1 = new Thread(writer);
        Thread thread2 = new Thread(writer);
        Thread thread3 = new Thread(reader);
        Thread thread4 = new Thread(reader);
    }
}
