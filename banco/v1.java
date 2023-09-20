package  banco;

public class v1 {
    static int balance = 0;
    static boolean turn = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                while (turn) {
                    // Espera activa
                }
                deposit(100);
                turn = true;
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                while (!turn) {
                    // Espera activa
                }
                withdraw(50);
                turn = false;
            }
        });

        t1.start();
        t2.start();
    }

    static synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposito de " + amount + " - Saldo: " + balance);
    }

    static synchronized void withdraw(int amount) {
        balance -= amount;
        System.out.println("Retiro de " + amount + " - Saldo: " + balance);
    }
}
