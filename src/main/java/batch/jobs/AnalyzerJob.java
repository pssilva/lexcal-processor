package batch.jobs;

import org.apache.log4j.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;

import factoryPattern.CheckParams;

public class AnalyzerJob implements Job {
	//AnalyzerJob
	static final String TAG = AnalyzerJob.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	private CheckParams checkParams;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isRestartable() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public JobParametersIncrementer getJobParametersIncrementer() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JobParametersValidator getJobParametersValidator() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCheckParams(CheckParams checkParams) {
		// TODO Auto-generated method stub
		this.checkParams = checkParams;
		
	}
	/**
	 * @return the checkParams
	 */
	public CheckParams getCheckParams() {
		return checkParams;
	}
	@Override
	public void execute(JobExecution execution) {
		// TODO Auto-generated method stub
		
	}
}
