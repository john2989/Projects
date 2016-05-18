package stubs;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMapper2 extends Mapper<LongWritable, Text, Text, Text> {
	
	Text text1 = new Text();
	int length = 0;
	Text text2 = new Text();

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  String line = value.toString(); 
	  for (String word : line.split("\\W+")){ 
		  
		  if (word.length() > 0) {
			  char ch=((word.toLowerCase()).charAt(0));
			  if(ch>='a' && ch<='z')
			  {
				  text1.set((word.substring(0,1)).toLowerCase());
				  text2.set(word);
				  length = word.length();
			  }
			  
			  Text t = new Text();
			  t.set(text2 + "," + length);
			  context.write(text1, t);
		  }
	  }
  }

}
