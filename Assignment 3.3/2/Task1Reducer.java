package project5;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class Task1Reducer extends Reducer<Text, Text,Text, IntWritable>
{	
	public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException
	{
		int count = 0;
		for (Text value : values) {
			if (value.toString().equalsIgnoreCase("onida"))
			{
			
				count ++;
		}
		}

		key.set("The total no of onida products sold in" + key);
		context.write(key, new IntWritable(count));
	}
}
