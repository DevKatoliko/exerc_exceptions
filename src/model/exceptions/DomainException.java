package model.exceptions;

public class DomainException extends Exception { //Nome da exceção
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {// Mensagem que a exceção terá é o parâmetro da classe
		super(msg);// Esse parâmetro é colocado também no construtor da super classe Exception
	}

}
