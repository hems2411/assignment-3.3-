package project7;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class Task1Reducer extends Reducer<Text, IntWritable,Text, IntWritable>
{	
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int count = 0;
		for (IntWritable value : values) {
			count += value.get();
			
		}
key.set("Total no of "+key+" sold is ");
		
		context.write(key, new IntWritable(count));
	}
}
