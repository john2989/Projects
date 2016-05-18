package stubs;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {
  DoubleWritable doubleWritable=new DoubleWritable();
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	int sum=0;
    double avgLength=0;
	int n=0;
    for (IntWritable value : values) { 
    	sum += value.get(); 
    	n++;
    	} 
    avgLength=(double)sum/n;
    doubleWritable.set(avgLength); 
    context.write(key, doubleWritable);

  }
}