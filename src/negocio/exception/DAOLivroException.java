package negocio.exception;

public class DAOLivroException extends Exception {
	public DAOLivroException(){
		super();
	}
	public DAOLivroException(String mensagem) {
		super(mensagem);
	}
	public DAOLivroException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
