package edu.stthomas.gps.tfidf;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.Mapper;


public class TfidfMapper extends Mapper<WordFilenameWritable, FloatWritable, FloatWritable, WordFilenameWritable> {
  
  @Override
  public void map(WordFilenameWritable key, FloatWritable value, Context context)
      throws IOException, InterruptedException {
	  
	  context.write(value, key);
	       
}
}