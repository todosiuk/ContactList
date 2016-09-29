package contact.dao;

public class DaoRunTimeException extends RuntimeException {

	public DaoRunTimeException(String msg) {
		super(msg);
	}

	public DaoRunTimeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
