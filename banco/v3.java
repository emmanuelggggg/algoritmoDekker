package banco;

public class v3 {
    static int balance = 0;
    static int turn = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                turn = 1;
                while (turn != 1) {
                    try {
                        Thread.sleep(1); // Espera durmiendo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                deposit(100);
                turn = 0;
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                turn = 2;
                while (turn != 2) {
                    try {
                        Thread.sleep(1); // Espera durmiendo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                withdraw(50);
                turn = 0;
            }
        });

        t1.start();
        t2.start();
    }

    static synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Dep�sito de " + amount + " - Saldo: " + balance);
    }

    static synchronized void withdraw(int amount) {
        balance -= amount;
        System.out.println("Retiro de " + amount + " - Saldo: " + balance);
    }
}
