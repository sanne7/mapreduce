package com.example.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper <LongWritable, Text, Text, IntWritable>
{
	private final static IntWritable count = new IntWritable(1);
	private Text word = new Text();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String line = value.toString();
		int i = line.indexOf("\"text\"");
		int j = line.indexOf("\"source\"");
		String tweet = line.substring(i+8, j-2);
		StringTokenizer itr = new StringTokenizer(tweet);
		while (itr.hasMoreTokens())
		{
			word.set(itr.nextToken());
			context.write(word, count);
		}
	}
}