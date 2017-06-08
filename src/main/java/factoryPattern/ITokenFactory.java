package factoryPattern;

public abstract class ITokenFactory {
	public abstract iToken
	/** Método Fabricado 
	 * @return */ 
	getToken(String type) throws Exception;
	
	public abstract iToken getTokenType(String type) throws Exception;
}
