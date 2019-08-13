package excepciones;

public class ExcepcionColumnaInvalida extends Exception{
	/**
	 * Error generado por ingresar un comando que no sea una columna valida
	 * @param msg
	 */
	public ExcepcionColumnaInvalida(String msg) {
		super(msg);
	}
}
