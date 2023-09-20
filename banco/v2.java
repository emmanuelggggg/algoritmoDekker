package banco;

public class v2 {
    static int balance = 0;
    static volatile boolean flag1 = false;
    static volatile boolean flag2 = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                flag1 = true;
                while (flag2) {
                    // Espera activa
                }
                deposit(100);
                flag1 = false;
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                flag2 = true;
                while (flag1) {
                    // Espera activa
                }
                withdraw(50);
                flag2 = false;
            }
        });

        t1.start();
        t2.start();
    }

    static void deposit(int amount) {
        balance += amount;
        System.out.println("Dep�sito de " + amount + " - Saldo: " + balance);
    }

    static void withdraw(int amount) {
        balance -= amount;
        System.out.println("Retiro de " + amount + " - Saldo: " + balance);
    }
}
