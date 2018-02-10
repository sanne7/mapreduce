package com.example.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer <Text, IntWritable, Text, IntWritable>
{
	private IntWritable result = new IntWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
	{		
		int sum = 0;
		for (IntWritable val : values)
		{
			sum += val.get();
		}
		if(sum > 50000){ //Words with occurrence more than 50,000
			result.set(sum);
			context.write(key, result); //Final Output
		}
		//Key is word 
		//result is number of occurrences of each word  
	}
}
