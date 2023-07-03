public class MultithreadedFizzBuzz {
    private final int n;
    private int counter;
    public MultithreadedFizzBuzz(int n) {
        this.n = n;
        this.counter = 1;
    }

    public synchronized void fizz() {
        while (counter <= n) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                System.out.print("fizz ");
                ++counter;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing;
                }
            }
        }
    }

    public synchronized void buzz() {
        while (counter <= n) {
            if (counter % 5 == 0 && counter % 3 != 0) {
                System.out.print("buzz ");
                ++counter;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (counter <= n) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.print("fizzbuzz ");
                ++counter;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }
    }

    public synchronized void number() {
        while (counter <= n) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                System.out.print(counter+ " ");
                ++counter;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }
    }
}
