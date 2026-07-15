import java.util.Random;

class IniArray extends Thread {
    private int[] numbers;
    private int start;
    private int stop;
    private int sum;

    public IniArray(int[] numbers, int start, int stop) {
        this.numbers = numbers;
        this.start = start;
        this.stop = stop;
    }

    public void run() {
        for (int i = start; i < stop; i++) {
            sum += numbers[i];
        }
    }

    public int getSum() {
        return sum;
    }
}

class Parallelism {
    public static void main(String[] args) throws InterruptedException {
        int numProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors: " + numProcessors);

        int arraySize = 100000;
        int[] numbers = new int[arraySize];
        Random rng = new Random();
        long totalSum = 0;
        
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = rng.nextInt(100000);
        }

        int portionSize = arraySize / numProcessors;
        IniArray[] threads = new IniArray[numProcessors];

        for (int i = 0; i < numProcessors; i++) {
            int start = i * portionSize;
            int stop = (i == numProcessors - 1) ? arraySize : (i + 1) * portionSize; //let it ride so it will calculate the remainder threads just in case
            threads[i] = new IniArray(numbers, start, stop);
            threads[i].start();
        }

        for (int i = 0; i < numProcessors; i++) {
            threads[i].join();
        }

        for (int i = 0; i < numProcessors; i++) {
            totalSum += threads[i].getSum();
            System.out.println("Thread " + i + ": " + threads[i].getSum());
        }
    }
}

