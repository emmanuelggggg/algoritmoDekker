package borrachos;

public class DekkerBorracho {
    private static boolean[] flag = {false, false};
    private static int turno = 0;

    public static void main(String[] args) {
        Thread borracho1 = new Thread(() -> {
            while (true) {
                System.out.println("Borracho 1: Esta bebiendo en el bar.");
                try {
                    Thread.sleep(2000); // Simular tiempo de bebida
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Borracho 1: Quiere usar el bano.");

                flag[0] = true;
                turno = 1;
                while (flag[1] && turno == 1) {
                    // Espera ocupada
                }

                System.out.println("Borracho 1: Esta usando el bano.");
                try {
                    Thread.sleep(3000); // Simular tiempo en el ba�o
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Borracho 1: Salio del bano.");
                flag[0] = false;
            }
        });

        Thread borracho2 = new Thread(() -> {
            while (true) {
                System.out.println("Borracho 2: Esta bebiendo en el bar.");
                try {
                    Thread.sleep(1500); // Simular tiempo de bebida
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Borracho 2: Quiere usar el bano.");

                flag[1] = true;
                turno = 0;
                while (flag[0] && turno == 0) {
                    // Espera ocupada
                }

                System.out.println("Borracho 2: Esta usando el bano.");
                try {
                    Thread.sleep(2500); // Simular tiempo en el ba�o
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Borracho 2: Salio del bao.");
                flag[1] = false;
            }
        });

        borracho1.start();
        borracho2.start();
    }
}
