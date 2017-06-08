package batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class MyCommandLineJobRunner extends CommandLineJobRunner {
	static final String TAG = MyCommandLineJobRunner.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	
}
