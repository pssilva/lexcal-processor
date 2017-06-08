package batch.chunks;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import factoryPattern.CheckParams;

public class AnalyzerReader implements ItemReader<CheckParams> {
	
	static final String TAG = AnalyzerReader.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	private CheckParams checkParams;

	public AnalyzerReader() {
		super();
		logger.info(TAG + " :: AnalyzerReader()");
		// TODO Auto-generated constructor stub
	}
	
	public AnalyzerReader(CheckParams checkParams) {
		super();
		this.checkParams = checkParams;
		logger.info(TAG + " :: AnalyzerReader(CheckParams)");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CheckParams read() throws Exception, UnexpectedInputException, 
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		logger.info(TAG + " :: read()");
		if(this.checkParams != null) return this.checkParams;
		return null;
	}

	
	
	
}
