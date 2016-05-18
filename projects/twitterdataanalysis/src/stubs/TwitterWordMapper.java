package stubs;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class TwitterWordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static enum Tweet {   
		NUM_TWEETS , 
		BAD_RECORD  }; 
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	context.getCounter(Tweet.NUM_TWEETS).increment(1); 
    try
    {
    String line1 = value.toString();
    if(line1.equalsIgnoreCase(null))
    	throw new NullPointerException();
    String line2[]=line1.split("\t");
    for (String word : line2[1].split("\\W+")) {
     
      if (word.length() > 0) {
        context.write(new Text(word), new IntWritable(1));
      }
    }
    }
	  catch(Exception e)
	  {
		  processError(context, e, value);
	  }
  }
  public void processError(Context c, Throwable e, Text v)
  { 
 System.err.println("Caught exception["+e+"] processing  value[" + v + "]");
 c.getCounter(Tweet.BAD_RECORD).increment(1); 
 	  
}
}