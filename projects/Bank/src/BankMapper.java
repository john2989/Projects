import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BankMapper
  extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

	IntWritable intWritable = new IntWritable();
	IntWritable one= new IntWritable(1);
	
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String line = value.toString(); 
	  for (String entry : line.split(" ")){ 
		     if(entry.length()>0)
		     {	 
			  intWritable.set(Integer.parseInt(entry));
			  context.write(intWritable, one); 
		     }
		  }
    }
  }

// ^^ BankMapper
