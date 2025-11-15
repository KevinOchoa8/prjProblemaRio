
package pkProblemaRio;
import java.util.Scanner;
import pkProblemaRio.pkActor.pkPersonaje.Lobo;
import pkProblemaRio.pkActor.pkPersonaje.Caperucita;
import pkProblemaRio.pkActor.pkPersonaje.Uva;

public class JuegoRio {
    // Estados de cada personaje
    private boolean vikingoIzq = true;
    private boolean loboIzq = true;
    private boolean caperucitaIzq = true;
    private boolean uvaIzq = true;

    private Scanner scanner = new Scanner(System.in);

    // Constructores de personajes
    private Lobo lobo = new Lobo("Lobo");
    private Caperucita caperucita = new Caperucita("Caperucita");
    private Uva uva = new Uva("Uvas");

    public void iniciarJuego() {
        System.out.println("¡Bienvenido al juego del río!");
        System.out.println("Debes cruzar el río con los personajes sin que se coman entre sí.");
        while (true) {
            mostrarEstado();
            if (verificarFin()) break;
            turno();
            if (verificarPeligro()) break;
        }
    }

    private void mostrarEstado() {
        System.out.println("\nOrilla Izquierda: " + obtenerPersonajes(true));
        System.out.println("Orilla Derecha: " + obtenerPersonajes(false));
    }

    private String obtenerPersonajes(boolean izquierda) {
        StringBuilder sb = new StringBuilder();
        if (vikingoIzq == izquierda) sb.append("Vikingo ");
        if (loboIzq == izquierda) sb.append("Lobo ");
        if (caperucitaIzq == izquierda) sb.append("Caperucita ");
        if (uvaIzq == izquierda) sb.append("Uvas ");
        return sb.toString();
    }

    private void turno() {
        System.out.println("\n¿A quién quieres llevar con el vikingo? (lobo/caperucita/uvas/ninguno)");
        String eleccion = scanner.nextLine().trim().toLowerCase();
        boolean personajeMovido = false;
        if (vikingoIzq) {
            vikingoIzq = false;
            if (eleccion.equals("lobo") && loboIzq) { loboIzq = false; personajeMovido = true; }
            else if (eleccion.equals("caperucita") && caperucitaIzq) { caperucitaIzq = false; personajeMovido = true; }
            else if (eleccion.equals("uvas") && uvaIzq) { uvaIzq = false; personajeMovido = true; }
        } else {
            vikingoIzq = true;
            if (eleccion.equals("lobo") && !loboIzq) { loboIzq = true; personajeMovido = true; }
            else if (eleccion.equals("caperucita") && !caperucitaIzq) { caperucitaIzq = true; personajeMovido = true; }
            else if (eleccion.equals("uvas") && !uvaIzq) { uvaIzq = true; personajeMovido = true; }
        }
        if (!eleccion.equals("ninguno") && !personajeMovido) {
            System.out.println("No puedes mover ese personaje.");
        }
    }

    private boolean verificarPeligro() {
        // Lobo y caperucita solos sin vikingo
        if (loboIzq == caperucitaIzq && loboIzq != vikingoIzq) {
            if (loboIzq) {
                lobo.comer(caperucita);
            } else {
                lobo.comer(caperucita);
            }
            System.out.println("Has perdido.");
            return true;
        }
        // Caperucita y uvas solos sin vikingo
        if (caperucitaIzq == uvaIzq && caperucitaIzq != vikingoIzq) {
            if (caperucitaIzq) {
                caperucita.comer(uva);
            } else {
                caperucita.comer(uva);
            }
            System.out.println("Has perdido.");
            return true;
        }
        return false;
    }

    private boolean verificarFin() {
        // Si Caperucita está en la orilla derecha, gana el juego
        if (!caperucitaIzq) {
            System.out.println("¡Ganaste! Caperucita cruzó el río.");
            return true;
        }
        return false;
    }
}
