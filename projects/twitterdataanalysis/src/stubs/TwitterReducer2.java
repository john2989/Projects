package stubs;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class TwitterReducer2 extends Reducer<IntWritable, Text, IntWritable, Text> {

  public void reduce (IntWritable key,Text value, Context context)
			throws IOException, InterruptedException {
		
		context.write(key, value);
	}
}