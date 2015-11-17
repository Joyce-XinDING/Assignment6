import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
// 3. Understand producer-consumer problem and implement it.

public class ProducerConsumerInJava {
  public static void main(String args[]) {
	  
      
      Queue<Integer> buffer = new LinkedList<>();
      int maxSize = 10;
      
      Thread producer = new Producer(buffer, maxSize, "PRODUCER");
      Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
      
      producer.start(); 
      consumer.start(); 
      }
  }