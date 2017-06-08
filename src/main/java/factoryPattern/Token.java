package factoryPattern;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

public class Token implements iToken, Runnable {
	
	private String tokenResults;
	public ArrayList<String> alTagsElems = new ArrayList<>();
	public static ArrayList<String> operador = new ArrayList<>();

	static private StringBuilder startJSON = new StringBuilder();
	static private StringBuilder bodyJSON = new StringBuilder();
	static private StringBuilder endJSON = new StringBuilder();
	
	{
		alTagsElems.add("w:document");
		alTagsElems.add("w:worddocument");
		alTagsElems.add("w:body");
		alTagsElems.add("w:p");
		alTagsElems.add("w:r");
		alTagsElems.add("w:t");
	}
	
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Token(String str) {
		super();
		//this.tokens = str;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getToken(String tag){
		
		this.setTokenResults(this.getTokenResults() + "{\""+TagTypes.TAG+"\": \""+tag+"\"},\n");
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

	@Override
	public void run() {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public String toString(){
		return tokenResults;
	}

	/**
	 * @return the startJSON
	 */
	public static StringBuilder getStartJSON() {
		return startJSON;
	}

	/**
	 * @param startJSON the startJSON to set
	 */
	public static void setStartJSON(StringBuilder startJSON) {
		Token.startJSON = startJSON;
	}
	
	/**
	 * @param startJSON the startJSON to set
	 */
	public static void setStartJSON(String startJSON) {
		Token.startJSON.append(startJSON);
	}

	/**
	 * @return the bodyJSON
	 */
	public static StringBuilder getBodyJSON() {
		return bodyJSON;
	}

	/**
	 * @param bodyJSON the bodyJSON to set
	 */
	public static void setBodyJSON(StringBuilder bodyJSON) {
		Token.bodyJSON = bodyJSON;
	}
	
	/**
	 * @param bodyJSON the bodyJSON to set
	 */
	public static void setBodyJSON(String bodyJSON) {
		Token.bodyJSON.append(bodyJSON);
	}
	

	/**
	 * @return the endJSON
	 */
	public static StringBuilder getEndJSON() {
		return endJSON;
	}

	/**
	 * @param endJSON the endJSON to set
	 */
	public static void setEndJSON(StringBuilder endJSON) {
		Token.endJSON = endJSON;
	}
	

	/**
	 * @param endJSON the endJSON to set
	 */
	public static void setEndJSON(String endJSON) {
		String end =  new String(Token.endJSON.toString());
		String auxEnd = new String((endJSON+end));
		Token.endJSON = new StringBuilder();
		Token.endJSON.append(auxEnd);
		end = auxEnd = null;
	}

	@Override
	public String getToken(Element element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
