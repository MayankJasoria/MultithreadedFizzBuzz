# Problem Statement
Suppose we have 4 threads t1, t2, t3, and t4. Thread t1 checks if a number is divisible by 3 and prints **fizz**. 
Thread t2 checks if a number is divisible by 5 and prints **buzz**. Thread t3 checks if a number is divisible by both 3
and 5 and prints **fizzbuzz**. Thread t4 prints numbers that are not divisible by 3 ot 5 and prints the number. The code
for the class is shown below:
```java
public class MultithreadedFizzBuzz {
    private final int n;
    public MultithreadedFizzBuzz(int n) {
        this.n = n;
    }

    public  void fizz() {
        System.out.print("fizz ");
    }

    public void buzz() {
        System.out.print("buzz ");
    }

    public void fizzbuzz() {
        System.out.print("fizzbuzz ");
    }

    public void number() {
        System.out.print(counter+ " ");
    }
}
```
For an input integer n, the program should output a string containing the words fizz, buzz, and fizzbuzz representing 
certain numbers. For example, for n = 15, the output should be: 
`1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz`

## Solution approach
1. Add a counter member variable to the class, initialized to 1 in the constructor.
2. Make all methods synchronized, and run a while loop that checks if a `counter` is less than or equal to n.
3. Within the loop, each method checks a condition. If the condition is true, output is printed, counbter is incremented
and `notifyAll()` is called to awaken other threads. Otherwise, the thread waits.
3. `fizz()` checks if the counter is divisible by 3 and not divisible by 5.
4. `buzz()` checks if the counter is divisible by 5 and not divisible by 3.
5. `fizzbuzz()` checks if the counter is divisible by 3 and by 5.
6. `number()` checks if the counter is not divisible by 3 and 5.

## Sample Output
```
Generating series upto 30
1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 23 fizz buzz 26 fizz 28 29 fizzbuzz 
```