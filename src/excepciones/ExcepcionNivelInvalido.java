package excepciones;

public class ExcepcionNivelInvalido extends Exception{
	
	/**
	 * Error generado por ingresar un nivel que no existe
	 * @param msg
	 */
	public ExcepcionNivelInvalido(String msg) {
		super(msg);
	}
}
