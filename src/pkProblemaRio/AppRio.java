package pkProblemaRio;


public class AppRio {

    public void iniciarJuegoRio() {
        
        System.out.println("==================== BIENVENIDO AL JUEGO DE DECISIÓN ======================");
        System.out.println("Tienes una barca y 3 personajes que llevar, pero tienes un problema");
        System.out.println("Tu barca solo te aguanta a ti y alguien más que elijas");
        System.out.println("======================= ¡PIENSA EN TUS DECISIONES! ========================");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            JuegoRio juego = new JuegoRio();
            juego.iniciarJuego();
            System.out.print("¿Deseas jugar otra vez? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("si")) {
                seguir = false;
                System.out.println("¡Gracias por jugar!");
            }
        }
    }
}
