package factoryPattern;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

public interface iToken {
	public String tokenResults = "";
	public ArrayList<String> operador = new ArrayList<>();
	
	public String getToken();
	public String getToken(String str);
	public String getToken(Element element);
	
	public static enum TagTypes { TAG, RUN, BLOCK_BEGIN, BLOCK_END, IDENTIFIER, OPERATOR, NUMBER}

}
