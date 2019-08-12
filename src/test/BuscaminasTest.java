package test;

import junit.framework.TestCase;
import modelo.Buscaminas;

public class BuscaminasTest extends TestCase{
	private Buscaminas buscaminas;
	private int nivel = 3;
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
			minas = 99;
		}
		return minas;
	}
	
	private String tableroNivel(int nivel) {
		String tablero = ""; 
		if(nivel == 1) {
			tablero ="   1  2  3  4  5  6  7  8  \n" +
					"1  -  -  -  -  -  -  -  -  \n" + 
					"2  -  -  -  -  -  -  -  -  \n" + 
					"3  -  -  -  -  -  -  -  -  \n" + 
					"4  -  -  -  -  -  -  -  -  \n" + 
					"5  -  -  -  -  -  -  -  -  \n" + 
					"6  -  -  -  -  -  -  -  -  \n" + 
					"7  -  -  -  -  -  -  -  -  \n" + 
					"8  -  -  -  -  -  -  -  -  \n";
		}else if(nivel == 2) {
			tablero ="   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 \n" + 
					"1  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"2  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"3  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"4  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"5  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"6  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"7  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"8  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"9  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"15 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"16 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n";
		}else if(nivel == 3) {
			tablero = "   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 \n" + 
					"1  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"2  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"3  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"4  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"5  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"6  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"7  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"8  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"9  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"15 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
					"16 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n";
		}
		return tablero;
	}
	
	public void testInicializarPartida() {
		setupEsceneario(nivel);
		boolean condition = buscaminas.darCasillas().length * buscaminas.darCasillas()[0].length == numeroCasillasNivel(nivel); 
		assertTrue(condition);
	}
	
	public void testGenerarMinas() {
		setupEsceneario(nivel);
		int minas = 0;
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(buscaminas.darCasillas()[i][j].esMina()) {
					minas++;
				}
			}
		}
		System.out.println(minas);
		assertEquals(minas,numeroMinasNivel(nivel));
	}
	
	public void testInicializarCasillasLibres() {
		setupEsceneario(nivel);
		int casillasLibres = 0;
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(!buscaminas.darCasillas()[i][j].esMina()) {
					casillasLibres++;
				}
			}
		}
		assertEquals(casillasLibres,numeroCasillasNivel(nivel)-numeroMinasNivel(nivel));
	}
	
	
	public void testMostrarTablero() {
		setupEsceneario(nivel);
		assertEquals(tableroNivel(nivel),buscaminas.mostrarTablero());
	}
	
	public void testResolver() {
		setupEsceneario(nivel);
		buscaminas.resolver();
		int casillasAbiertas = 0;
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(buscaminas.darCasillas()[i][j].darSeleccionada()) {
					casillasAbiertas++;
				}
			}
		}
		
		assertTrue(casillasAbiertas==numeroCasillasNivel(nivel));
	}
}
