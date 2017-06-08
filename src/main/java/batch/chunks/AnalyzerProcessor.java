package batch.chunks;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import factoryPattern.CheckParams;

public class AnalyzerProcessor implements ItemProcessor<CheckParams, CheckParams>, ItemWriter<Object> {
	//AnalyzerProcessor
	static final String TAG = AnalyzerProcessor.class.getSimpleName();
	static Logger logger = Logger.getLogger(TAG + "Log");
	
	public AnalyzerProcessor() {
		super();
		logger.info(TAG + " :: AnalyzerProcessor()");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CheckParams process(CheckParams item) throws Exception {
		// TODO Auto-generated method stub
		logger.info(TAG + " :: process()");
		
		return item;
	}

	@Override
	public void write(List items) throws Exception {
		// TODO Auto-generated method stub
		logger.info(TAG + " :: write()");
		
	}

	
	
}
