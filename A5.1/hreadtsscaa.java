public class hreadtsscaa extends Thread{
    private int numero;
    private boolean isOdd;
    private int maxNum;

    public hreadtsscaa(int numero, boolean isOdd, int maxNum) {
        this.numero = numero;
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print(numero++);
                Thread.sleep(1000);
                if (numero % 2 == 0) {
                    isOdd = false;
                }
            }
        }

        catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}