
package pkProblemaRio.Actor.Personaje;

public class Lobo extends Personaje{
	public Lobo(String nombre) {
		super(nombre);
	}

	public void comer(Caperucita caperucita) {
		System.out.println("El lobo ha comido a Caperucita");
	}
}
