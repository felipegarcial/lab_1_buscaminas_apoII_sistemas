/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de solución laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelo;

import java.util.Random;

public class Buscaminas {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel intermedio
	 */
	public static final int INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * intermedio
	 */
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------
	private int cantMinas;
	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores
	 * PRINCIPIANTE, INTERMEDIO, EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * 
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a
	 * partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {
		switch (this.nivel) {
		case PRINCIPIANTE:
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			cantMinas = CANTIDAD_MINAS_PRINCIPANTE;
			break;
		case INTERMEDIO:
			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			cantMinas = CANTIDAD_MINAS_INTERMEDIO;
			break;
		case EXPERTO:
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			cantMinas = CANTIDAD_MINAS_EXPERTO;
			break;
		default:
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			break;
		}
		generarMinas();
		inicializarCasillasLibres();
		inicializarValorCasillasLibres();
	}

	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[1].length; j++) {
				if (casillas[i][j] == null) {
					casillas[i][j] = new Casilla(Casilla.LIBRE);
				}
			}
		}
	}
	
	
	/**
	 * Método para inicializar los valores de cada casilla según las minas
	 * hay alrededor.
	 */
	public void inicializarValorCasillasLibres() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				int minasAlrededor = cantidadMinasAlrededor(i,j);
				if(minasAlrededor>0) {
					casillas[i][j].modificarValor(minasAlrededor);
				}
			}
		}
	}

	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una
	 * casillas
	 * 
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int i, int j) {
		int contadorMinas = 0;
		// =========================
		if (i - 1 >= 0 && j - 1 >= 0 && casillas[i - 1][j - 1].esMina()) {
			contadorMinas += 1;
		}
		if (j - 1 >= 0 && casillas[i][j - 1].esMina()) {
			contadorMinas += 1;
		}
		if (i + 1 < casillas.length && j - 1 >= 0 && casillas[i + 1][j - 1].esMina()) {
			contadorMinas += 1;
		}
		// =========================
		if (i - 1 >= 0 && casillas[i - 1][j].esMina()) {
			contadorMinas += 1;
		}
		if (i + 1 < casillas.length && casillas[i + 1][j].esMina()) {
			contadorMinas += 1;
		}
		// =========================
		if (i - 1 >= 0 && j + 1 < casillas[0].length && casillas[i - 1][j + 1].esMina()) {
			contadorMinas += 1;
		}
		if (j + 1 < casillas[0].length && casillas[i][j + 1].esMina()) {
			contadorMinas += 1;
		}
		if (i + 1 < casillas.length && j + 1 < casillas[0].length && casillas[i + 1][j + 1].esMina()) {
			contadorMinas += 1;
		}
		// =========================
		return contadorMinas;
	}

	/**
	 * Método que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {

		Random random = new Random();

		int indice = 0;

		while (indice < cantMinas) {
			int numAleX = random.nextInt(darCasillas().length);
			int numAleY = random.nextInt(darCasillas()[0].length);
			if (casillas[numAleX][numAleY] == null) {
				casillas[numAleX][numAleY] = new Casilla(Casilla.MINA);
				indice++;
			}

		}
	}

	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en
	 * pantalla
	 * 
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {

		String tableroString = "";
		String tabStrNumCol = "";
		// ------------------------
		for (int i = 0; i < casillas.length; i++) {
			tableroString += (i + 1);
			tableroString += i + 1 < 10 ? "  " : " ";
			for (int j = 0; j < casillas[0].length; j++) {
				if (i == 0) {
					tabStrNumCol += (j + 1);
					tabStrNumCol += j + 1 < 10 ? "  " : " ";
				}
				// ------------------------
				tableroString += casillas[i][j].mostrarValorCasilla() + "  ";
				// ------------------------
				if (j == casillas[0].length - 1) {
					tableroString += "\n";
				}
				// ------------------------
			}
		}
		// ------------------------
		return "   " + tabStrNumCol + "\n" + tableroString;
	}

	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if (!casillas[i][j].darSeleccionada()) {
					casillas[i][j].destapar();
				}
			}
		}
	}

	/**
	 * Metodo dar del atributo casillas
	 * 
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas() {
		return casillas;
	}

	/**
	 * Este metodo se encargaa de abrir una casilla Si se abre una casilla de tipo
	 * Mina, se marca que el jugador perdio el juego.
	 * 
	 * @param i - la fila donde esta la casilla
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) {
		if (casillas[i][j].esMina()) {
			perdio = true;
		}

		if (!casillas[i][j].darSeleccionada()) {
			casillas[i][j].destapar();
			return true;
		}
		return false;
	}

	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * 
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		int contadorCasillasAbiertas = 0;
		// ------------------------------
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if (casillas[i][j].darSeleccionada()) {
					contadorCasillasAbiertas++;
				}
			}
		}
		// ------------------------------
		int cantCasillas = casillas.length * casillas[0].length;
		// ------------------------------
		if (contadorCasillasAbiertas - cantMinas == cantCasillas - cantMinas) {
			return true;
		}

		return false;
	}

	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo
	 * valor sea Mayor que 0
	 * 
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber
	 *         casillas posibles para dar una pista, retorna el mensaje no hay
	 *         pistas para dar
	 */
	public String darPista() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if (!casillas[i][j].esMina() && !casillas[i][j].darSeleccionada() && casillas[i][j].darValor() > 0) {
					casillas[i][j].destapar();
					return "Se abrió la casilla en la fila:" + " " + (i + 1) + " " + "y en la culumna:" + " " + (j + 1);
				}
			}
		}

		return "No hay pistas para dar";
	}

	/***
	 * Metodo dar del atributo perdio
	 * 
	 * @return boolean el atributo
	 */
	public boolean darPerdio() {
		return perdio;
	}

}