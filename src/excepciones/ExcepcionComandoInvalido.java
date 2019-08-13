package excepciones;

public class ExcepcionComandoInvalido extends Exception{
	/**
	 * Error generado por ingresar un comando que no sea los siguientes
	 * 1. Abrir una casilla 
	 * 2. Dar pista 
	 * 3. Ver la solución del Buscaminas 
	 * 4. Salir 
	 * @param msg
	 */
	public ExcepcionComandoInvalido(String msg) {
		super(msg);
	}
}
