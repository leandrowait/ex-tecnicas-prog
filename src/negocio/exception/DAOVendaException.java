package negocio.exception;

public class DAOVendaException extends Exception{
	public DAOVendaException(){
		super();
	}
	public DAOVendaException(String mensagem) {
		super(mensagem);
	}
	public DAOVendaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
