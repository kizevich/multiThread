package book;

import java.io.*;

public class BookReader implements Runnable{

    FileReader fr = null;
    Object locker = new Object();

    public BookReader(String filePath, Object locker) {
        try {
            this.fr = new FileReader(filePath);
            this.locker = locker;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        BufferedReader br = new BufferedReader(fr);
        try {
            while (br.readLine() != null) {
                synchronized (locker) {
                    br.read();
                    System.out.println("reading...");
                    locker.notify();
                    locker.wait();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
