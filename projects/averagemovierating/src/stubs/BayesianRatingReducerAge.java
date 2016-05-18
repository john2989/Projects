package stubs;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class BayesianRatingReducerAge extends Reducer<IntWritable, Text, IntWritable, Text> {
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
    if(data[4].contains("under18bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(10*3.35))/(votes+10);
    else if(data[4].contains("18-24bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(54*3.17))/(votes+54);
    else if(data[4].contains("25-34bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(113*3.32))/(votes+113);
    else if(data[4].contains("35-44bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(58*3.29))/(votes+58);
    else if(data[4].contains("45-49bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(25*3.3))/(votes+25);
    else if(data[4].contains("50-55bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(22*3.35))/(votes+22);
    else if(data[4].contains("above55bayesianratingIP"))
    bayesianRating=((votes*movieAvg)+(13*3.37))/(votes+13);
    doubleWritable.set(bayesianRating); 
    text.set(data[0].toString()+"\t"+data[1]+"\t"+data[2]+"\t"+data[3]+"\t"+doubleWritable.toString());
    context.write(key, text);
	}

  }
}