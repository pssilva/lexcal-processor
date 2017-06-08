package factoryPattern;


public class ConcreteFactory extends ITokenFactory {

	private String tokenResults;

	@Override
	public iToken getToken(String type) throws Exception {
		// TODO Auto-generated method stub
		switch (type) {
			case "BLOCK_BEGIN":
				return new TokenBLOCK_BEGIN(); 
			case "BLOCK_END":
				return new TokenBLOCK_END(); 
			case "IDENTIFIER":
				return new TokenIDENTIFIER(); 
			case "NUMBER":
				return new TokenNUMBER(); 
			case "OPERATOR":
				return new TokenOPERATOR();
			case "RUN":
				return new TokenRUN();
			case "TAG":
				return new TokenTAG(); 
			default:
				throw new Exception( "O tipo Token : "+type+" não pode ser instânciado");
		}
	}
	
	public void setTokenResults(String tokenResults){
		this.tokenResults = tokenResults;
	}
	
	@Override
	public String toString(){
		return "{\n" +
		 "	\"tokens\": [\n" +
		 "		"+ tokenResults.substring(0,tokenResults.length()-1) +
		 "	 ]\n" +
		 "}";	
	}

	@Override
	public iToken getTokenType(String type) throws Exception {
		// TODO Auto-generated method stub
		return getToken(type);
	}

	

}
