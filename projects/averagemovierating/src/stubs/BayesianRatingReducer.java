package stubs;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class BayesianRatingReducer extends Reducer<IntWritable, Text, IntWritable, Text> {
  DoubleWritable doubleWritable=new DoubleWritable();
  Text text=new Text();
  @Override
	public void reduce(IntWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
	  
	for(Text value:values)
	{
    double bayesianRating= 0;
	String data[]= value.toString().split("\\t");
    double votes=Double.parseDouble(data[2]);
    double movieAvg=Double.parseDouble(data[1]);
    bayesianRating=((votes*movieAvg)+(1191*3.23))/(votes+1191);
    //bayesianRating=((votes*movieAvg)+(270*3.24))/(votes+270);
    doubleWritable.set(bayesianRating); 
    text.set(value.toString()+"\t"+doubleWritable.toString());
    context.write(key, text);
	}

  }
}