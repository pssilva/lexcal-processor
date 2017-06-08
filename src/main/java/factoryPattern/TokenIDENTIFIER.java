package factoryPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenIDENTIFIER extends Token {
	
	public static final String TAG_CLASSE_NAME = TokenIDENTIFIER.class.getName();
	private String tokenResults;
	private TokenOPERATOR to;
	
	public TokenIDENTIFIER() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TokenIDENTIFIER(String str) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String token){
		String tokenTmp = "";
		Pattern pattern = Pattern.compile("\\{(\\w+)\\}|\\{(\\w+ (\\+|\\-|\\*|\\%|\\/) \\w+)\\}");
		Matcher m = pattern.matcher(token);
		String tmpOPERATOR = "";
		this.setTokenResults("");
		if(m.find()){
			String tokenMatcher = m.group();
			tokenTmp += "		{\""+TagTypes.BLOCK_BEGIN+"\": \"{\"},\n";
			pattern = Pattern.compile("\\{(\\w+ (\\+|\\-|\\*|\\%|\\/) \\w+)\\}");
			m = pattern.matcher(tokenMatcher);
			tokenMatcher = tokenMatcher.replace("{", "").replace("}", "");
			if(m.find()) {
				to = new TokenOPERATOR();
				tmpOPERATOR = to.getToken(m.group());
				
				String[] aIdentifieds = tokenMatcher.split("\\"+to.getOperator(m.group()));
				//pattern = Pattern.compile("\\D+");
				//float cFloat = Float.valueOf(aIdentifieds[0]);
				//NumberUtils.isNumber(myStringValue);
				
				
				
				if (!aIdentifieds[0].trim().matches("-?\\d+(.\\d+)?"))  
					tokenTmp += "		{\""+TagTypes.IDENTIFIER+"\": \""+aIdentifieds[0].trim()+"\"},\n";
				else tokenTmp += "		{\""+TagTypes.NUMBER+"\": \""+aIdentifieds[0].trim()+"\"},\n";
				
				tokenTmp += tmpOPERATOR;
				
				if (!aIdentifieds[1].trim().matches("-?\\d+(.\\d+)?")) 
					tokenTmp += "		{\""+TagTypes.IDENTIFIER+"\": \""+aIdentifieds[1].trim()+"\"},\n";
				else tokenTmp += "		{\""+TagTypes.NUMBER+"\": \""+aIdentifieds[1].trim()+"\"},\n";
				
			} else
				tokenTmp += "		{\""+TagTypes.IDENTIFIER+"\": \""+tokenMatcher+"\"},\n";
			
			tokenTmp += "		{\""+TagTypes.BLOCK_END+"\": \"}\"},\n";
		
			this.setTokenResults(tokenTmp);
		}
		tokenTmp = tmpOPERATOR = null;
		pattern = null;
		m = null;
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
