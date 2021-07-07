package book;

import java.io.*;
import java.util.Random;

public class BookWriter implements Runnable{

    FileWriter fw = null;
    Object locker;
    Random random = new Random();

    public BookWriter(String filePath, Object locker) {
        try {
            this.fw = new FileWriter(filePath, true);
            this.locker = locker;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        synchronized (locker) {
            for (int i = 1; i < random.nextInt(111); i++) {
                try {
                    fw.write("nm ");
                    System.out.println("writing...");
                    locker.notify();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
