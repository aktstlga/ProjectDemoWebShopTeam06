package Utility;

public class Myfunc {
    public static void wait(int second){
        try {
            Thread.sleep(second *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
