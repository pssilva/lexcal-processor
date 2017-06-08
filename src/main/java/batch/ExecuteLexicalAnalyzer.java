package batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import batch.chunks.AnalyzerReader;
import batch.jobs.AnalyzerJobLauncher;

public class ExecuteLexicalAnalyzer {
	  static final String TAG = ExecuteLexicalAnalyzer.class.getSimpleName();
	  static Logger logger = Logger.getLogger(TAG + "Log");
  
  public static void main(String[] args) {
	String[] springConfig  = {"batch/lexicalAnalyzerBatch.xml"};
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	AnalyzerJobLauncher jobLauncher = (AnalyzerJobLauncher) context.getBean("analyzerJobLauncher");
	
	Job job = (Job) context.getBean("analyzerJobId");
	ParametersBuilderValidator parametersBuilderValidator = (ParametersBuilderValidator) context.getBean("parametersBuilderValidator");
	AnalyzerReader analyzerReader = (AnalyzerReader) context.getBean("analyzerReader");
	try {
		parametersBuilderValidator.validate(args);
		//jobLauncher.setCheckParams(parametersBuilderValidator.getCheckParams());
		//job.setCheckParams(parametersBuilderValidator.getCheckParams());
		JobExecution execution = jobLauncher.run(job, parametersBuilderValidator.toJobParameters());
		
	    logger.info("ExecuteLexicalAnalyzer :: Exit Status : " + execution.getStatus());
	      
	} catch (Exception e) {
	      e.printStackTrace();
	} finally {
	    if (context != null) {
	      context = null;
	    }
	}
	logger.info("ExecuteLexicalAnalyzer :: Done");
  }
}