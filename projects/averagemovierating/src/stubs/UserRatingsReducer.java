package stubs;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UserRatingsReducer extends Reducer<IntWritable, IntWritable, IntWritable, Text> {
  DoubleWritable doubleWritable=new DoubleWritable();
  IntWritable intWritable=new IntWritable();
  Text text=new Text();
  
  @Override
  public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {
	int sumRatingsUser=0;
    double avgRatingUser=0;
	int n=0, one=0, two=0, three=0, four=0, five=0;
    for (IntWritable value : values) { 
    	sumRatingsUser += value.get();
    	if(value.get()==5)
    		five++;
    	else if(value.get()==4)
    		four++;
    	else if(value.get()==3)
    		three++;
    	else if(value.get()==2)
    		two++;
    	else if(value.get()==1)
    		one++;
    	n++;
    	} 
    avgRatingUser=(double)sumRatingsUser/n;
    doubleWritable.set(avgRatingUser); 
    intWritable.set(n);
    text.set(doubleWritable.toString()+"\t"+intWritable.toString()+"\t"+five+"\t"+four+"\t"+three+"\t"+two+"\t"+one);
    context.write(key, text);

  }
}