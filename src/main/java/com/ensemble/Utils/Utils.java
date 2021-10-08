package com.ensemble.Utils;

public class Utils {
	
	public static int getNumberOfPages(long numberOfRecords,int batchSize) {
		long maxRecords=(numberOfRecords>batchSize)?batchSize:numberOfRecords;
		return (int) Math.ceil((double)numberOfRecords/maxRecords);
	}

}
