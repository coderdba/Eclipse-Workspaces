package com.gm.kafka.producer.simple;


// README: Add to build-path the following:
//         (also in classpath while running this program)
//         kafka-clients-NNNN.jar

// To run:
// java -cp "/Users/myusername/opt/kafka_2.10-0.10.0.0/libs/*":"./kafka-simple-producer/target/kafka-simple-producer-0.0.1-SNAPSHOT.jar" com.gm.kafka.producer.simple.SimpleProducer topic2

//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;

//Create java class named “SimpleProducer”
public class SimpleProducer {
 
 public static void main(String[] args) throws Exception{
    
    // Check arguments length value
    if(args.length == 0){
       System.out.println("Enter topic name");
       return;
    }
    
    //Assign topicName to string variable
    String topicName = args[0].toString();
    
    // create instance for properties to access producer configs   
    Properties props = new Properties();
    
    //Assign localhost id
    props.put("bootstrap.servers", "localhost:9092");
    
    //Set acknowledgements for producer requests.      
    props.put("acks", "all");
    
    //If the request fails, the producer can automatically retry,
    props.put("retries", 0);
    
    //Specify buffer size in config
    props.put("batch.size", 16384);
    
    //Reduce the no of requests less than 0   
    props.put("linger.ms", 1);
    
    //The buffer.memory controls the total amount of memory available to the producer for buffering.   
    props.put("buffer.memory", 33554432);
    
    props.put("key.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
       
    props.put("value.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    
    Producer<String, String> producer = new KafkaProducer<String, String>(props);
          
    for(int i = 0; i < 10; i++)
       producer.send(new ProducerRecord<String, String>(topicName, 
          Integer.toString(i), Integer.toString(i)));
             System.out.println("Message sent successfully");
             producer.close();
 }
}