package stubs;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReducer1 extends Reducer<Text, IntWritable, Text, IntWritable> {
  IntWritable intWritable=new IntWritable();
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	
	int maxLength=0;
	
    for (IntWritable value : values) {
    	
    	if(value.get()> maxLength){
    	maxLength=value.get();
    	} 
    }
   
    intWritable.set(maxLength); 
    context.write(key, intWritable);

  }
}