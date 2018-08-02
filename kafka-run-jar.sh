if [ $# lt 1 ]
then

echo USAGE:  $0 your_lan_username
exit

fi

myusername=$1

# Example
#java -cp "/Users/${myusername}/opt/kafka_2.10-0.10.0.0/libs/*":"./kafka-simple-producer/target/kafka-simple-producer-0.0.1-SNAPSHOT.jar" com.gm.kafka.producer.simple.SimpleProducer topic2

# actual ones
#java -cp "/Users/${myusername}/opt/kafka_2.10-0.10.0.0/libs/*":"./kafka-simple-producer/target/kafka-simple-producer-0.0.1-SNAPSHOT.jar" com.gm.kafka.producer.simple.SimpleProducer topic2

java -cp "/Users/${myusername}/opt/kafka_2.10-0.10.0.0/libs/*":"kafka/kafka-binary-file-publish-consume/target/kafka-binary-file-publish-consume-0.0.1-SNAPSHOT.jar" com.gm.kafka.binfile.BinaryProducer kafka.binary.properties

