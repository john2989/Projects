import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class BankReducer2
  extends Reducer<IntWritable, Text, IntWritable, IntWritable> {
  IntWritable intWritable1= new IntWritable();
  IntWritable intWritable2= new IntWritable();
  @Override
  public void reduce(IntWritable key, Iterable<Text> values,
      Context context)
      throws IOException, InterruptedException {
    
    int totalBills= 0;
    int totalBillAmount= 0;
    for (Text value : values) {
    	String str[]=(value.toString()).split(" ");
    	totalBills = totalBills+Integer.parseInt(str[0]);
    	totalBillAmount= totalBillAmount+Integer.parseInt(str[1]);
    }
    intWritable1.set(totalBills);
    intWritable2.set(totalBillAmount);
    context.write(intWritable1, intWritable2);
  }
}
// ^^ BankReducer2
