package batch.tasks;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.task.TaskExecutor;

public class AnalyzerTask implements TaskExecutor, Tasklet {
	
  static final String TAG = AnalyzerTask.class.getSimpleName();
  static Logger logger = Logger.getLogger(TAG + "Log");
  private String fileIn;
	
  public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) 
		  throws Exception {
	  		logger.info("** First Batch Job is Executing! **");
	  		return RepeatStatus.FINISHED;
  }

	@Override
	public void execute(Runnable task) {
		//this.execute(task);
		// TODO Auto-generated method stub
		logger.info(TAG + " :: execute(Runnable) >>>>");
		
	}
}