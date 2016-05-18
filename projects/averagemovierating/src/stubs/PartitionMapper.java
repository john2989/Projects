package stubs;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class PartitionMapper extends Mapper<LongWritable, Text, Text, Text> {
	Text textKey = new Text();
	Text textValue = new Text();
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
	  String line= value.toString(); 
	  String str[]= line.split("\t");
	  if(str.length>4)
		  throw e;
	  else if(str[0].contains(" ")||str[1].contains(" ")||str[2].contains(" ")||str[3].contains(" "))
		  throw e;
	  else if(!((str[0].matches("[0-9]+"))&&(str[1].matches("[0-9]+"))&&(str[2].matches("[0-9]+"))&&((str[3].matches("[0-9]+"))||(str[3].matches("[a-zA-Z]")))))
		  throw e;
	  textKey.set(str[3]);
	  textValue.set(str[0]+"\t"+str[1]+"\t"+str[2]);
	  context.write(textKey, textValue); 
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
