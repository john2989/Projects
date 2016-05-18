package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class TwitterWordMapper2 extends Mapper<LongWritable, Text, IntWritable, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  Text text=new Text();
	  IntWritable intWritable=new IntWritable();
	  String line = value.toString();
	  String str[]=line.split("\\W+");
	  int k=Integer.parseInt(str[1]);
	  String v=str[0];
	  text.set(v);
	  intWritable.set(k);
	  context.write(intWritable, text);
      
    
  }
}