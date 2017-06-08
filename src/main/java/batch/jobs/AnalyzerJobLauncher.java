package batch.jobs;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import factoryPattern.CheckParams;
import factoryPattern.controller.AnalyzerController;


public class AnalyzerJobLauncher extends SimpleJobLauncher {
	static final String TAG = AnalyzerJobLauncher.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	private CheckParams checkParams;

	public AnalyzerJobLauncher() {
		super();
		logger.info(TAG + " :: AnalyzerJobLauncher()");
	}
	
	public AnalyzerJobLauncher(CheckParams checkParams) {
		super();
		this.checkParams = checkParams;
		logger.info(TAG + " :: AnalyzerJobLauncher(CheckParams)");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public JobExecution run(final Job job, final JobParameters jobParameters) 
			throws JobExecutionAlreadyRunningException, JobRestartException, 
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		AnalyzerController netLexCal = new AnalyzerController();
		String fi = jobParameters.getString("-fi");
		String fo = jobParameters.getString("-fo");
		this.checkParams = new CheckParams();
		netLexCal.setFileIn(fi);
		netLexCal.setFileOut(fo);
		netLexCal.processFiles();
		
		return super.run(job, jobParameters);
	}

	/**
	 * @return the checkParams
	 */
	public CheckParams getCheckParams() {
		return checkParams;
	}

	/**
	 * @param checkParams the checkParams to set
	 */
	public void setCheckParams(CheckParams checkParams) {
		this.checkParams = checkParams;
	}
}
