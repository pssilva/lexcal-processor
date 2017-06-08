package factoryPattern;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(Principal.fileLogger);

	public AppException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		setLogger(message);
		// TODO Auto-generated constructor stub
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
		setLogger(message);
		// TODO Auto-generated constructor stub
	}

	public AppException(String message) {
		super(message);
		setLogger(message);
	}

	public AppException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	private void setLogger(String message){
	    LOGGER.setLevel(Level.SEVERE);
	    LOGGER.setUseParentHandlers(false);
	    //Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh; 
	    
	    try {
			fh = new FileHandler(Principal.fileLogger);
			LOGGER.addHandler(fh) ;
			LOGGER.setUseParentHandlers(true);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter); 
	        
	        LOGGER.severe(message);
	        
		} catch (SecurityException | IOException e) {
			LOGGER.setLevel(Level.SEVERE);
		    LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}  
	}
}
	
	
	
	


