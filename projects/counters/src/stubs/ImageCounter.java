package stubs;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import stubs.ImageCounterMapper.ImageCounterEnum;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class ImageCounter extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: ImageCounter <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(ImageCounter.class);
    job.setMapperClass(ImageCounterMapper.class);
    job.setJobName("Image Counter");
    job.setMapOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    job.setNumReduceTasks(0);
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    /*
     * TODO implement
     */

    boolean success = job.waitForCompletion(true);
    if (success) {
      /*
       * Print out the counters that the mappers have been incrementing.
       * TODO implement
       */
    	System.out.println("JPG: "+(job.getCounters().findCounter(ImageCounterEnum.JPEG)).getValue());
    	System.out.println("GIF: "+(job.getCounters().findCounter(ImageCounterEnum.GIF)).getValue());
    	System.out.println("OTHER: " +(job.getCounters().findCounter(ImageCounterEnum.OTHER)).getValue());
    	
      return 0;
    } else
      return 1;

  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new ImageCounter(), args);
    System.exit(exitCode);
  }
}