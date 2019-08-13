package excepciones;

public class ExcepcionFilaInvalida extends Exception {
	/**
	 * Error generado por ingresar un comando que no sea una columna valida
	 * @param msg
	 */
	public ExcepcionFilaInvalida(String msg) {
		super(msg);
	}
}
