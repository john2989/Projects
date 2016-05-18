import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BankMapper2
  extends Mapper<LongWritable, Text, IntWritable, Text> {

	IntWritable intWritable1 = new IntWritable();
	IntWritable intWritable2= new IntWritable();
	Text text= new Text();
	int amountPerBill=0;
	int bill=0;
	int noOfBills=0;

	
	
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String line[] = (value.toString()).split("\t"); 
	  bill=Integer.parseInt(line[0]);
	  noOfBills=Integer.parseInt(line[1]);
	  amountPerBill=bill*noOfBills;
	  text.set(Integer.toString(noOfBills)+" "+Integer.toString(amountPerBill));
	  context.write(new IntWritable(1), text);
	  
    }
  }

// ^^ BankMapper2
