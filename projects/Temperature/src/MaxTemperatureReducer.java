// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer
  extends Reducer<Text, IntWritable, Text, Text> {
	Text text= new Text();
	
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
	  String str="";
    
    
    for (IntWritable value : values) {
      str.concat(Integer.toString(value.get()));
    }
    
    text.set(str);
    context.write(key, text);
  }
}
// ^^ MaxTemperatureReducer
