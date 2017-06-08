package factoryPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenBLOCK_END extends Token {

	public static final String TAG_CLASSE_NAME = TokenBLOCK_END.class.getName();
	private String tokenResults;
	
	public TokenBLOCK_END() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TokenBLOCK_END(String str) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String token){
		Pattern pattern = Pattern.compile("\\b\\}\\b");
		Matcher m = pattern.matcher(token);
		this.setTokenResults("");
		
		if(m.find()){
			String tokenMatcher = m.group();
			this.setTokenResults("		999{\""+TagTypes.BLOCK_END+"\": \""+tokenMatcher+"\"},\n");
		}
		
//		this.setTokenResults("");
//		this.setTokenResults("		{\""+TagTypes.BLOCK_END+"\": \""+token+"\"},\n");
		
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
