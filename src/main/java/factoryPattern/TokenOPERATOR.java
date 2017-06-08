package factoryPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

public class TokenOPERATOR extends Token {

	public static final String TAG_CLASSE_NAME = TokenTAG.class.getName();
	private String tokenResults;
	
	public TokenOPERATOR() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TokenOPERATOR(String str) {
		super();
		//this.tokens = str;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String token){
		
		String operator = this.getOperator(token);
		this.setTokenResults("		{\""+TagTypes.OPERATOR+"\": \""+operator+"\"},\n");
		return this.getTokenResults();
		
	}
	

	public String getOperator(String token) {
		 
		 if(token.indexOf("*") > 0) return "*";
		 else if(token.indexOf("/") > 0) return "/";
		 else if(token.indexOf("+") > 0) return "+";
		 else if(token.indexOf("-") > 0) return "-";
		 else if(token.indexOf("%") > 0) return "%";
		
		return null;
	}

	@Override
	public String getToken(Element token){
		
		Pattern pattern = Pattern.compile("[A-Za-z0-9]\\{\\[A-Za-z0-9]\\}\\[A-Za-z0-9]");
		Matcher m = pattern.matcher(token.nodeName());
		this.setTokenResults("");
		if(m.find()){
			this.setTokenResults("		{\""+TagTypes.OPERATOR+"\": \""+token+"\"},\n");
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
