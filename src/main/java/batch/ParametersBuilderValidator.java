package batch;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

import factoryPattern.CheckParams;

public class ParametersBuilderValidator extends JobParametersBuilder 
	implements JobParametersValidator {
   /**
    * 
    */
	private static final long serialVersionUID = 1L;
	static final String TAG = ParametersBuilderValidator.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	private String fileIn;
	private String fileOut;
	private CheckParams checkParams;
	JobParametersBuilder jobParametersBuilder;

	public ParametersBuilderValidator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ParametersBuilderValidator(Map<String, JobParameter> parameters) {
		//super(parameters);
		
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public ParametersBuilderValidator(String[] args, JobParameters parameters) {
		//super((Map<String, JobParameter>) parameters);
		logger.info(TAG + " :: ParametersBuilderValidator()");
		this.validate(args, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {
		logger.info(TAG + " :: validate()");
		// TODO Auto-generated method stub
	}
	
	public void validate(String[] args, JobParameters jobParameters) {
		// TODO Auto-generated method stub
		logger.info(TAG + " :: validate()");
	}
	
	/**
	 * @return the fileIn
	 */
	public String getFileIn() {
		return fileIn;
	}

	/**
	 * @param fileIn the fileIn to set
	 */
	public void setFileIn(String fileIn) {
		this.fileIn = fileIn;
	}

	/**
	 * @return the fileOut
	 */
	public String getFileOut() {
		return fileOut;
	}

	/**
	 * @param fileOut the fileOut to set
	 */
	public void setFileOut(String fileOut) {
		this.fileOut = fileOut;
	}


	public JobParameters validate(String[] args) throws JobParametersInvalidException {
		// TODO Auto-generated method stub
		this.checkParams = new CheckParams(args);
		if(checkParams.checkLength() == 4){
			if(checkParams.getNameParam().contains("-fi")){
				this.addString("-fi", checkParams.getArgs(1));
			}

			if(checkParams.getNameParam().contains("-fo")){
				this.addString("-fo", checkParams.getArgs(3));
			}
		}
		//validate(this.checkParams);
		logger.info(TAG + " :: validate()");
		
		return null;
	}
	
	public CheckParams validate(final CheckParams checkParams) throws JobParametersInvalidException, IOException {
		// TODO Auto-generated method stub
		this.checkParams = checkParams;
		this.checkParams.checkLength();
		this.checkParams.checkNameParam();
		this.checkParams.checkFiles();
		logger.info(TAG + " :: validate(CheckParams)");
		return this.checkParams;
	}

	public CheckParams getCheckParams() {
		return checkParams;
	}

	public void setCheckParams(CheckParams checkParams) {
		this.checkParams = checkParams;
	}

}
