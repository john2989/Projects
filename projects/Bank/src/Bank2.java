import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;

public class Bank2 extends Configured implements Tool {

  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.err.println("Usage: Bank2 <input path> <output path>");
      System.exit(-1);
    }
    
    Job job = new Job(getConf());
    job.setJarByClass(Bank2.class);
    job.setJobName("Bank2");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(BankMapper2.class);
    job.setReducerClass(BankReducer2.class);

    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(IntWritable.class);
    job.setMapOutputKeyClass(IntWritable.class);
    job.setMapOutputValueClass(Text.class);
    
    return (job.waitForCompletion(true) ? 0 : 1);
  }

  public static void main(String[] args) throws Exception {
    int res = ToolRunner.run(new Configuration(), new Bank2(), args);
    System.exit(res);
  }
}
// ^^ Bank2
