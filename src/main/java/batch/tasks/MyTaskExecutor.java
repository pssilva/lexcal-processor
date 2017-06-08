package batch.tasks;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;


public class MyTaskExecutor implements TaskExecutor {
	
	static final String TAG = MyTaskExecutor.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");

	@Override
	public void execute(Runnable task) {
		// TODO Auto-generated method stub
		logger.info(TAG + " :: execute(Runnable)");
		
	}

}
