package factoryPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

public class TokenRUN extends Token {
	
	public static final String TAG_CLASSE_NAME = TokenRUN.class.getName();
	private String tokenResults;
	private ArrayList<String> tagIn =  new ArrayList<>(Arrays.asList("w:p"));
	private TokenIDENTIFIER ti;
	
	public TokenRUN() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TokenRUN(String str) {
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
			this.setTokenResults("		{\""+TagTypes.RUN+"\": \""+tokenMatcher+"\"},\n");
		}
		return this.getTokenResults();
	}
	

	@Override
	public String getToken(Element token){
		
		String templateTagStart = "<w:r><w:t>";
		String templateTagEnd = "</w:t></w:r>";
		String tmpToken = "";
		String[] aTmp;
		
		this.setTokenResults("");
		
		if(!this.tagIn.contains(token.nodeName())) return this.getTokenResults();
		
		String text = token.text();

		aTmp = text.split("\\{");
		tmpToken += (aTmp.length > 1)?"		{\""+TagTypes.RUN+"\": \""+templateTagStart + aTmp[0] + templateTagEnd+"\"},\n":"";
		Pattern pattern = Pattern.compile("\\{(\\w+)\\}| \\{(\\w+ (\\+|\\-|\\*|\\%|/) \\w+)\\}");
		Matcher m = pattern.matcher(text);
		
		if(m.find()){
			this.ti = new TokenIDENTIFIER();
			tmpToken += this.ti.getToken(m.group());
		}

		aTmp = text.split("\\}");
		tmpToken += (aTmp.length > 1)?"		{\""+TagTypes.RUN+"\": \""+templateTagStart + aTmp[1] + templateTagEnd+"\"},\n":"";
		
		Token.setBodyJSON(tmpToken);
		
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
