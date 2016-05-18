package stubs;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BayesianRatingMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
	
	IntWritable intWritable = new IntWritable();
	Text text=new Text();

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	 
	  String line = value.toString(); 
	  String data[]=line.split("\\t");  
	  intWritable.set(Integer.parseInt(data[0]));
      text.set(data[1].toString()+"\t"+data[2]+"\t"+data[3]+"\t"+data[4]);	  
	  context.write(intWritable, text); 
	  }
	 
	  }
 

  

