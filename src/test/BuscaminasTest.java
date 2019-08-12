package test;

import junit.framework.TestCase;
import modelo.Buscaminas;
import modelo.Casilla;

public class BuscaminasTest extends TestCase{
	private Buscaminas buscaminas;
	private Casilla[][] casillas;
	private int nivel = 1;
	private void setupEsceneario(int nivel) {
		buscaminas = new Buscaminas(nivel);
	}
	
	private int numeroCasillasNivel(int nivel) {
		int casillas = 0; 
		if(nivel == 1) {
			casillas = 64;
		}else if(nivel == 2) {
			casillas = 256;
		}else if(nivel == 3) {
			casillas = 480;
		}
		return casillas;
	}
	
	private int numeroMinasNivel(int nivel) {
		int minas = 0; 
		if(nivel == 1) {
			minas = 10;
		}else if(nivel == 2) {
			minas = 40;
		}else if(nivel == 3) {
			minas = 90;
		}
		return minas;
	}
	
	public void testInicializarPartida() {
		setupEsceneario(nivel);
		boolean condition = buscaminas.darCasillas().length * buscaminas.darCasillas()[0].length == numeroCasillasNivel(nivel); 
		assertTrue(condition);
	}
	
	public void testGenerarMinas() {
		setupEsceneario(nivel);
		boolean condition = buscaminas.darCasillas().length * buscaminas.darCasillas()[0].length == numeroCasillasNivel(nivel); 
		assertTrue(condition);
	}
}
