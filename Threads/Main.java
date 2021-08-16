package Threads;

import static Threads.ThreadColor.ANSI_PURPLE;
import static Threads.ThreadColor.ANSI_GREEN;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from Main");

        AnotherThread thread = new AnotherThread();
        thread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

        System.out.println(ANSI_PURPLE + "Hello again from Main");
    }
    
}
