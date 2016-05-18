import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper2
  extends Mapper<LongWritable, Text, Text, IntWritable> {

	IntWritable intWritable = new IntWritable();
	Text text= new Text();
	int temp=0;
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String line[] = (value.toString()).split("\t"); 
	  temp=Integer.parseInt(line[1]);
	  intWritable.set(temp);
	  text.set("Maximum Temperature across all years");
	  context.write(text, intWritable);
	  
    }
  }

// ^^ MaxTemperatureMapper2
