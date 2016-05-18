package stubs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class OccupationPartitioner<K2, V2> extends Partitioner<Text, Text> 
{
	public int getPartition(Text key, Text value, int numReduceTasks) 
	 {  
		    int k=Integer.parseInt(key.toString());
			return k%numReduceTasks;
		
			
	 } 
}
