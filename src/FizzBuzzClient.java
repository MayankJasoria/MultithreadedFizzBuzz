import java.util.concurrent.ThreadLocalRandom;

public class FizzBuzzClient {
    public static void main(String[] args) throws InterruptedException {
        int n = ThreadLocalRandom.current().nextInt(15, 70);
        System.out.println("Generating series upto " + n);
        MultithreadedFizzBuzz fizzBuzz = new MultithreadedFizzBuzz(n);
        Thread t1 = new Thread(fizzBuzz::fizz);
        Thread t2 = new Thread(fizzBuzz::buzz);
        Thread t3 = new Thread(fizzBuzz::fizzbuzz);
        Thread t4 = new Thread(fizzBuzz::number);

        // starting threads in any random order
        t3.start();
        t2.start();
        t1.start();
        t4.start();

        // wait for completion
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
