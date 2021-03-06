package stubs;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NYSEReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
  FloatWritable floatWritable = new FloatWritable();
  Text text=new Text();
  
  @Override
  public void reduce(Text key, Iterable<FloatWritable> values, Context context)
      throws IOException, InterruptedException {
	float max=0;
	String s="";
	s=key.toString();
	String str[]=s.split(",");
	String newKey=str[0];
	text.set(newKey);
    for (FloatWritable value : values) { 
    	if(value.get()>max)
    	max=value.get(); 
    	} 
    floatWritable.set(max);
    context.write(text, floatWritable);

  }
}