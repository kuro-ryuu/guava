class hreadtsscaa extends Thread {
    private int start;
    private boolean isOdd;
    private int maxNum;

    public hreadtsscaa(int numero, int maxNum, boolean isOdd) {
        this.start = numero;
        this.maxNum = maxNum;
        this.isOdd = isOdd;
    }

    public void run() {
        for (int i = start; i <= maxNum; i++) {
            if (isOdd) {
                if (i % 2 == 0) {
                    System.out.println("Even Thread: " + i);
                }
            } else {
                if (i % 2 == 1) {
                    System.out.println("Odd Thread: " + i);
                }
            }
        }
    }
}

public class Man {
    public static void main(String[] args) {
        hreadtsscaa thread1 = new hreadtsscaa(0, 10, true);
        hreadtsscaa thread2 = new hreadtsscaa(0, 10, false);
        thread1.start();
        thread2.start();
    }
}