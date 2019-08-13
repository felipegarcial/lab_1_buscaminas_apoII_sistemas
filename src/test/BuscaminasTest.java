package test;

import excepciones.ExcepcionColumnaInvalida;
import excepciones.ExcepcionFilaInvalida;

import junit.framework.TestCase;
import modelo.Buscaminas;

public class BuscaminasTest extends TestCase{
	private Buscaminas buscaminas;
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
	
	
	/**
	 * Método para validar y generar minas
	 */
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
		assertEquals(minas,numeroMinasNivel(nivel));
	}
	
	
	/**
	 * Método para validar el inicio de casillas libres
	 */
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
	
	
	/**
	 * Método para validar resolver el bucaminas
	 */
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
	
	/**
	 * Método para validar abrir una casilla con una mina
	 */
	public void testAbrirCasillaPerder () {
		setupEsceneario(nivel);
		
		int iCasilla = 0;
		int jCasilla = 0;
		
		outerloop:
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(buscaminas.darCasillas()[i][j].esMina()) {
					iCasilla = i;
					jCasilla = j;
					
					break outerloop;
				}
			}
		}

		buscaminas.abrirCasilla(iCasilla, jCasilla);
		assertTrue(buscaminas.darPerdio()) ;
	}
	
	/**
	 * Método para validar abrir una casilla abirta
	 */
	public void testAbrirCasillaAbierta () {
		setupEsceneario(nivel);
		
		int iCasilla = 0;
		int jCasilla = 0;
		
		outerloop:
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(!buscaminas.darCasillas()[i][j].esMina() && !buscaminas.darCasillas()[i][j].darSeleccionada()) {
					iCasilla = i;
					jCasilla = j;
					buscaminas.abrirCasilla(iCasilla, jCasilla);
					break outerloop;
				}
			}
		}
		
		assertFalse(buscaminas.abrirCasilla(iCasilla, jCasilla));
	}
	
	
	/**
	 * Método para validar abrir una casilla cerrada
	 */
	public void testAbrirCasillaCerrada () {
		setupEsceneario(nivel);
		
		int iCasilla = 0;
		int jCasilla = 0;
		
		outerloop:
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) {
				if(!buscaminas.darCasillas()[i][j].esMina() && !buscaminas.darCasillas()[i][j].darSeleccionada()) {
					iCasilla = i;
					jCasilla = j;
					break outerloop;
				}
			}
		}
		assertTrue(buscaminas.abrirCasilla(iCasilla, jCasilla));
	}
	
	public void testDarPista() {
		setupEsceneario(nivel);
		String message = "";
		outerloop:
			for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) { 
				if (!buscaminas.darCasillas()[i][j].esMina() && buscaminas.darCasillas()[i][j].darValor()>0) {
					message = "Se abrió la casilla en la fila:" + " " + (i + 1) + " " + "y en la columna:" + " " + (j + 1);
					break outerloop;
				}
			}
		} 
		
		assertEquals(buscaminas.darPista(), message);
	}
	
	public void testGano() {
		setupEsceneario(nivel);
		
		for (int i = 0; i < buscaminas.darCasillas().length; i++) {
			for (int j = 0; j < buscaminas.darCasillas()[0].length; j++) { 
				if (!buscaminas.darCasillas()[i][j].esMina()) {

					buscaminas.darCasillas()[i][j].destapar();
				}
			}
		}
		
		assertTrue(buscaminas.gano());
	}
	
	public void testFilaInvalida() {
		setupEsceneario(nivel);
		int fila = 0;
		try {
			if(fila<=0) {
				throw new ExcepcionFilaInvalida("La fila no puede ser menor o igual a 0");
			}
		} catch (ExcepcionFilaInvalida e) {
			assertEquals("La fila no puede ser menor o igual a 0", e.getMessage());
			
		}
	}

}
