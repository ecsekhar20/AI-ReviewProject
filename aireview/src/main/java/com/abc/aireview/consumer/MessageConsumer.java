package com.abc.aireview.consumer;

import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abc.aireview.constants.ReviewConstants;
import com.abc.aireview.model.InvoiceData;
import com.abc.aireview.repository.ReviewRepository;

@Component
public class MessageConsumer {

	private int[] items = new int[] { 1, 2 };

	private Random rand = new Random();
	@Autowired
	private ReviewRepository repo;

	
	 @RabbitListener(queues = ReviewConstants.QUEUE) 
	 	 public void  consumeMessageFromQueue(InvoiceData data) {
	 
	 //Update the record with user and status
	  
	  int i=getRandArrayElement(); data.setUser("Analyst-"+i);
	  data.setStatus("Completed"); repo.save(data);
	  
	  System.out.println("Message Consumed from Queue and the Acknowledge is sent to AIservice"+data.getId());
	  
	  }
	 

	public int getRandArrayElement() {
		return items[rand.nextInt(items.length)];
	}

}
