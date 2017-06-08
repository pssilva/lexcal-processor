package factoryPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenBLOCK_BEGIN extends Token {

	public static final String TAG_CLASSE_NAME = TokenBLOCK_BEGIN.class.getName();
	private String tokenResults;
	
	public TokenBLOCK_BEGIN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TokenBLOCK_BEGIN(String str) {
		super();
		//this.tokens = str;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String token){
		Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
		Matcher m = pattern.matcher(token);
		this.setTokenResults("");
		
		if(m.find()){
			this.setTokenResults("		{\""+TagTypes.BLOCK_BEGIN+"\": \"{\"},\n");
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
