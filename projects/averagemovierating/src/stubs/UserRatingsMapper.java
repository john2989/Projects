package stubs;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class UserRatingsMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
	
	IntWritable intWritable1 = new IntWritable();
	IntWritable intWritable2 = new IntWritable();
	Text text=new Text();
	Exception e= new Exception();
	int failedRecords;
	public static enum Counters
	{
		FAILED_RECORDS
	}
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  try
	  {
	  String line = value.toString(); 
	  String data[] = line.split("\\$");
	  if(data.length>4)
		  throw e;
		  else if(data[0].contains(" ")||data[1].contains(" ")||data[2].contains(" ")||data[3].contains(" "))
		  throw e;
		  else if(!((data[0].matches("[0-9]+"))&&(data[1].matches("[0-9]+"))&&(data[2].matches("[0-9]+"))&&(data[3].matches("[0-9]+"))))
		  throw e;
	  intWritable1.set(Integer.parseInt(data[0]));
	  intWritable2.set(Integer.parseInt(data[2]));
	  context.write(intWritable1, intWritable2);   
	  }
	  catch(Exception e)
	  {
		  processError(context, e, value);
	  }
	  }
  public void processError(Context c, Throwable e, Text v)
  { 
 System.err.println("Caught exception["+e+"] processing  value[" + v + "]");
 c.getCounter(Counters.FAILED_RECORDS).increment(1); 
 c.setStatus("Records with failures = " +(++failedRecords));	  	  
}
  }

