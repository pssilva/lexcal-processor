package factoryPattern.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import factoryPattern.AppException;
import factoryPattern.CheckParams;
import factoryPattern.ITokenFactory;
import factoryPattern.Token;
import factoryPattern.TokenBLOCK_BEGIN;
import factoryPattern.TokenBLOCK_END;
import factoryPattern.TokenIDENTIFIER;
import factoryPattern.TokenNUMBER;
import factoryPattern.TokenOPERATOR;
import factoryPattern.TokenRUN;
import factoryPattern.TokenTAG;
import factoryPattern.iToken;

public class AnalyzerController extends ITokenFactory {

	public static final String TAG_CLASSE_NAME = AnalyzerController.class.getName();
	private File fileIn;
	private File fileOut;
	private CheckParams cp;
	
	public AnalyzerController(){}
	
	public AnalyzerController(String[] args){
		try {
			this.cp = new CheckParams(args);
			this.cp.checkNameParam();
			this.cp.checkLength(args);
			this.cp.checkFiles();

			this.fileIn = this.cp.getFileIn();
			this.fileOut = this.cp.getFileOut();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			String msn = e.getMessage();
			e.printStackTrace();
			throw new AppException(msn);
		}
	}
	
	
	/**
	 * @return the fileIn
	 */
	public File getFileIn() {
		return fileIn;
	}
	/**
	 * @param fileIn the fileIn to set
	 */
	public void setFileIn(File fileIn) {
		this.fileIn = fileIn;
	}
	
	public void setFileIn(String fullFileInPath)  throws AppException{
		this.fileIn = new File(fullFileInPath);
		///Users/pssilva/Downloads
		if(!this.fileIn.exists()){
			String msn = "\n\n\tO arquivo de entrada (-fi '"+fullFileInPath+"') não existe. \n"+
					   "\tForneça um arquivo de entrava válido!\n";
			throw new AppException(msn);
		}
	}

	/**
	 * @param fileIn the fileIn to set
	 * @throws IOException 
	 */
	public void setFileOut(String fullFileOutPath) {
		this.fileOut = new File(fullFileOutPath);
		if(!this.fileOut.exists()){
			//this.createFile(this.fileOut.getParent());
			try {
				this.fileOut.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @return the fileOut
	 */
	public File getFileOut() {
		return fileOut;
	}
	/**
	 * @param fileOut the fileOut to set
	 */
	public void setFileOut(File fileOut) {
		this.fileOut = fileOut;
	}
	
	public void processFiles() {
		Document doc;
		try {
				doc = Jsoup.parse(this.fileIn, "UTF-8");
				StringBuffer sbisOut = new StringBuffer();
				
				Elements allElements = doc.getAllElements();
				Token t = new Token();
				for (Element element : allElements) {
				  String sTag = element.tagName();
				  
					  if(t.alTagsElems.contains(sTag)) {
						  this.getToken(element); 
					  }
				}

				String wrap = "{\n" +
							  "	\"tokens\": [\n"+
							  "{BODY}\n" +
							  "	 ]\n"+
							  "}\n";
				StringBuffer result = new StringBuffer();
				String tokenTagStart = Token.getStartJSON().toString();
				String tokenTagBody = Token.getBodyJSON().toString();
				String tokenTagEnd = Token.getEndJSON().deleteCharAt(Token.getEndJSON().length()-1).toString();
				result.append(tokenTagStart + tokenTagBody  + tokenTagEnd);
				wrap = wrap.replace("{BODY}", result.deleteCharAt(result.length()-1));
				
				result = new StringBuffer();
				sbisOut = result.append(wrap);
				
				PrintWriter writer = new PrintWriter(this.fileOut.toPath().toFile(), "UTF-8");
				writer.println(sbisOut);
				writer.close();
				
				result = sbisOut = null;
				wrap = null; 
				writer = null;
				t = null;
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getToken(Element element){
		
		String result = "";
		try {
			iToken tokenTAG = this.getTokenType("TAG");
			result += tokenTAG.getToken(element);
			
			iToken tokenRUN = this.getTokenType("RUN");
			result += tokenRUN.getToken(element);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public iToken getTokenType(String type) throws Exception {
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

	@Override
	public iToken getToken(String type) throws Exception {
		return getTokenType(type);
	}	
}
