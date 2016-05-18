import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class BankReducer
  extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
  
  @Override
  public void reduce(IntWritable key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    int total= 0;
    for (IntWritable value : values) {
    	total = total+Integer.parseInt(value.toString());
    }
    context.write(key, new IntWritable(total));
  }
}
// ^^ BankReducer
