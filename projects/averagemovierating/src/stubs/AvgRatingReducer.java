package stubs;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgRatingReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, Text> {
  DoubleWritable doubleWritable=new DoubleWritable();
  IntWritable intWritable=new IntWritable();
  Text text=new Text();
  
  @Override
  public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
      throws IOException, InterruptedException {
	double sumRatings=0;
    double avgRating=0;
	int n=0;
    for (DoubleWritable value : values) { 
    	sumRatings += value.get(); 
    	n++;
    	} 
    avgRating=(double)sumRatings/n;
    doubleWritable.set(avgRating); 
    intWritable.set(n);
    text.set(doubleWritable.toString()+"\t"+intWritable.toString());
    context.write(key, text);

  }
}