package factoryPattern;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckParams implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String TAG_CLASSE_NAME = CheckParams.class.getName();
	public static String templateMsg;
	private String[] args; 
	private static int paramsLength = -1;
	private List<String> nameParam;
	private File fileIn;
	private File fileOut;
	
	{
		templateMsg = "{MSN}" +
			       "\tExemplo: $java -jar NetLexCal -fi '/PATH_TO_FILE/name_file_in.xml' " + 
			       "-fo '/PATH_DESTINATION/name_file_out.json' \n\n";
	}
	
	public CheckParams() {
		super();
	}

	public CheckParams(String[] args) {
		super();
		this.nameParam = new ArrayList<String>(Arrays.asList(args));
		this.args = args;
		paramsLength = args.length;
	}
	
	public int checkLength (String[] args) throws AppException {
		
		//this(args);
		if(paramsLength == 0 || paramsLength < 4 ) {
			String msn = templateMsg.replace("{MSN}", "\n\n\tFaltam os parâmetros: \n"+
												   "\t\t-fi [Arquivo de Entrada - File In];\n" +
					       						   "\t\t-fo [Arquivo de Saída - File Out];\n\n" );
			throw new AppException(msn);
		}
		return paramsLength;
	}
	
	public int checkLength () throws AppException {
		
		if(paramsLength == 0 || paramsLength < 4 ) {
			String msn = templateMsg.replace("{MSN}", "\n\n\tFaltam os parâmetros: \n"+
												   "\t\t-fi [Arquivo de Entrada - File In];\n" +
					       						   "\t\t-fo [Arquivo de Saída - File Out];\n\n" );
			throw new AppException(msn);
		}
		return paramsLength;
	}
	
	public void checkNameParam() throws AppException {
		//if(paramsLength==-1) CheckParams(args);
		if(!this.nameParam.contains("-fi")){
			String msn = templateMsg.replace("{MSN}", "\n\n\tFalta o parâmetro de entrada: \n"+
					   "\t\t-fi [Arquivo de Entrada - File In];\n" );
			throw new AppException(msn);
		}
		if(!this.nameParam.contains("-fo")){
			String msn = templateMsg.replace("{MSN}", "\n\n\tFalta o parâmetro de saída: \n"+
					   "\t\t-fo [Arquivo de Saída - File Out];\n" );
			throw new AppException(msn);
		}
	}
	
	public boolean checkFiles() throws IOException {
		List<String> alNameParams = this.getNameParam();
		alNameParams.remove("-fi");
		alNameParams.remove("-fo");
		Pattern pattern;
		Matcher matcher;
		boolean result = false;
		for(String param: alNameParams){
			//private static final na
			 pattern = Pattern.compile("[A-Za-z0-9].xml");
			 matcher = pattern.matcher(param);
			 result = matcher.find();
			if(result){
				this.setFileIn(param);
			}
			
			 pattern = Pattern.compile("[A-Za-z0-9].json");
			 matcher = pattern.matcher(param);
			 result = matcher.find();
			if(result){
				this.setFileOut(param);
			}
		}
		
		return result;
	}
	
	/**
	 * @return the nameParam
	 */
	public List<String> getNameParam() {
		return nameParam;
	}

	/**
	 * @param nameParam the nameParam to set
	 */
	public void setNameParam(ArrayList<String> nameParam) {
		this.nameParam = nameParam;
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
	
	public void setFileIn(String fullFileInPath)  throws AppException{
		this.fileIn = new File(fullFileInPath);
		if(!this.fileIn.exists()){
			String msn = "\n\n\tO arquivo de entrada (-fi '"+fullFileInPath+"') não existe. \n"+
					   "\tForneça um arquivo de entrava válido!\n";
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
	 * @return the fileOut
	 */
	public File getFileOut() {
		return fileOut;
	}

	public String getArgs(int i) {
		// TODO Auto-generated method stub
		return this.args[i];
	}
	
}
