package com.ensemble.Utils;

public class Utils {
	/**
	 * Get number of pages based on batch size. Used for pagination API. 
	 * @param numberOfRecords
	 * @param batchSize
	 * @return
	 */
	public static int getNumberOfPages(long numberOfRecords,int batchSize) {
		long maxRecords=(numberOfRecords>batchSize)?batchSize:numberOfRecords;
		return (int) Math.ceil((double)numberOfRecords/maxRecords);
	}

}
