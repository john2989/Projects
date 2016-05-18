package edu.stthomas.gps.tfidf;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class TfidfReducer extends Reducer<FloatWritable, WordFilenameWritable, FloatWritable, WordFilenameWritable> 
{
	public void reduce (FloatWritable key, WordFilenameWritable value, Context context)
			throws IOException, InterruptedException {
		
		context.write(key, value);
	}
}

  
