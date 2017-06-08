package factoryPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

public class TokenTAG extends Token {
	
	public static final String TAG_CLASSE_NAME = TokenTAG.class.getName();
	private String tokens;
	private String tokenResults;
	private ArrayList<String> tagNotIn =  new ArrayList<>(Arrays.asList("w:p","w:r","w:t"));
	
	public TokenTAG() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TokenTAG(String str) {
		super();
		//this.tokens = str;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(Element token){
		
		String templateTagStart = "<{TAG}>".replace("{TAG}", token.tagName());
		String templateTagEnd = "</{TAG}>".replace("{TAG}", token.tagName());
		
		this.setTokenResults("");
		
		if(tagNotIn.contains(token.tagName())) return this.getTokenResults();
		
		Token.setStartJSON("		{\""+TagTypes.TAG+"\": \""+templateTagStart+"\"},\n");
		Token.setEndJSON("		{\""+TagTypes.TAG+"\": \""+templateTagEnd+"\"},\n");
		
		return this.getTokenResults();
	}
	
	@Override
	public String getToken(String token){
		
		Pattern pattern = Pattern.compile("\b\\{[a-zA-Z0-9]\\}\b");
		Matcher m = pattern.matcher(token);
		this.setTokenResults("");
		System.out.println(TAG_CLASSE_NAME +" :: "+token);
		
		if(m.find()){
			String tokenMatcher = m.group();
			this.setTokenResults("		{\""+TagTypes.TAG+"\": \""+tokenMatcher+"\"},\n");
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
