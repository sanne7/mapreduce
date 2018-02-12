# mapreduce
Most used words in Super Bowl 2018 Tweets?
This Map Reduce program to count the number of occurrences of each word in all tweets using Java MapReduce.

-------------------------------------------------------------
Findings:

Word Eagles is used more than patriots.
win	49861
winning	3307
won	605
RT	324430
Nick	4842
....


--------------------------------------------------------------  

Executing MapReduce job in Linux environment

* Export java code to Jar file. (twwc.jar)      
	
* All daemons are supposed to be running. 
  Command 
	start-all.sh
 	jps

* Create directory in HDFS and keep data file we want to process ( tweet.txt ). 
   Command 
	hdfs dfs -mkdir /twitter_word_count-in
	hdfs dfs -put tweet.data /twitter_word_count-in

* Run Yarn
Command 
	yarn jar twwc.jar wordcount.twitterWordCount /twitter_word_count-in /twitter_word_count-out01

* After MapReduce Job executed, check output files
	hdfs dfs -ls /twitter_word_count-out01

We will get two output files here, first file shows our MapReduce job is sucessful and second one shows actual output (Each word and its number of occurrences.)

* hdfs dfs -cat /twitter_word_count-out01/part-r-000001










