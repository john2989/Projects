package stubs;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable; 
import org.apache.hadoop.mapreduce.Partitioner;  

public class NYSEPartitioner<K2, V2> extends Partitioner<Text, FloatWritable> 
{
	public int getPartition(Text key, FloatWritable value, int numReduceTasks) 
	 {  
		char c=key.toString().charAt(0);
		return (int)c-65;
	 } 
}

 