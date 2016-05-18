// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;

public class MaxTemperature2 extends Configured implements Tool {

  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.err.println("Usage: MaxTemperature2 <input path> <output path>");
      System.exit(-1);
    }
    
    Job job = new Job(getConf());
    job.setJarByClass(MaxTemperature2.class);
    job.setJobName("Max temperature 2");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(MaxTemperatureMapper2.class);
    job.setReducerClass(MaxTemperatureReducer2.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    return (job.waitForCompletion(true) ? 0 : 1);
  }

  public static void main(String[] args) throws Exception {
    int res = ToolRunner.run(new Configuration(), new MaxTemperature2(), args);
    System.exit(res);
  }
}
// ^^ MaxTemperature2
