package banco;

public class v4 {

        private static int turno = 0;
        private static boolean[] want = {false, false};
        private static boolean[] choosing = {false, false};

        public static void main(String[] args) {
            Thread cliente1 = new Thread(() -> {
                while (true) {
                    choosing[0] = true;
                    want[0] = true;
                    choosing[0] = false;

                    while (choosing[1]) {
                        // Espera ocupada
                    }

                    while (turno != 0 && want[1]) {
                        // Espera ocupada
                    }

                    // Secci�n cr�tica: realizar el dep�sito
                    System.out.println("Cliente 1: Realiz� un dep�sito");
                    want[0] = false;
                    turno = 1;
                }
            });

            Thread cliente2 = new Thread(() -> {
                while (true) {
                    choosing[1] = true;
                    want[1] = true;
                    choosing[1] = false;

                    while (choosing[0]) {
                        // Espera ocupada
                    }

                    while (turno != 1 && want[0]) {
                        // Espera ocupada
                    }

                    // Secci�n cr�tica: realizar el retiro
                    System.out.println("Cliente 2: Realiz� un retiro");
                    want[1] = false;
                    turno = 0;
                }
            });

            cliente1.start();
            cliente2.start();
        }
    }

