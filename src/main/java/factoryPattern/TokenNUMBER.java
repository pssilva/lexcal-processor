package factoryPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenNUMBER extends Token {

	public static final String TAG_CLASSE_NAME = TokenNUMBER.class.getName();
	private String tokenResults;
	
	public TokenNUMBER() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TokenNUMBER(String str) {
		super();
		//this.tokens = str;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String token){
		
		Pattern pattern = Pattern.compile("[A-Za-z0-9]\\{\\[A-Za-z0-9]\\}\\[A-Za-z0-9]");
		Matcher m = pattern.matcher(token);
		this.setTokenResults("");
		
		if(m.find()){
			String tokenMatcher = m.group();
			this.setTokenResults("		{\""+TagTypes.NUMBER+"\": \""+tokenMatcher+"\"},\n");
		}
		
		return this.getTokenResults();
		
	}


	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getTokenResults() {
		return tokenResults;
	}


	public void setTokenResults(String tokenResults) {
		this.tokenResults = tokenResults;
	}

	
}
