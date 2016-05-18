package stubs;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;  

public class GenderPartitioner<K2, V2> extends Partitioner<Text, Text> 
{
	public int getPartition(Text key, Text value, int numReduceTasks) 
	 {  
		if(key.toString().equals("M"))
			return 0;
		else
			return 1%numReduceTasks;
			
	 } 
}

 