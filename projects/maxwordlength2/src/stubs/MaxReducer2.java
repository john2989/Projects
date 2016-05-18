package stubs;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReducer2 extends Reducer<Text, Text, Text, Text> {
 
  Text output = new Text();

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	
	int maxLength=0;
	String maxWord ="";
    for (Text value : values) {
    	String val = value.toString();
    	String[] splitValues = val.split(",");
    	int length = Integer.parseInt(splitValues[1]);
    	if(length>maxLength)
    	{
    		maxLength = length;
    	    maxWord = splitValues[0];
    	}
    	
    	// Code for displaying all words that correspond to maximum length of each letter	
    	/*if(length >= maxLength){
    		if(length == maxLength){
    			if(!maxWord.toLowerCase().contains(splitValues[0].toLowerCase()))
    				maxWord = maxWord + "," + splitValues[0];
    		}
    		else
    			maxWord = splitValues[0];
    		maxLength = length;
    	
    	}*/
    }
    output.set(maxLength + " " + maxWord);
 
    context.write(key, output);

  }
}

