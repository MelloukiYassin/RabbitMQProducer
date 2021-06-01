package org.rabbitmq.training1.producer.impl;

import org.rabbitmq.training1.json.Student;
import org.rabbitmq.training1.producer.IProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer implements IProducer {

    private AmqpTemplate amqpTemplate;

    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Value("${udemy.rabbitmq.exchange}")
    private String exchange;

    @Value("${udemy.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public void produceMessage(Student student) {
        if(exchange.equals("udemy") && routingkey.equals("udemy.routingkey")){
            amqpTemplate.convertAndSend(exchange, routingkey, student);
            System.out.println("Sending message - "+student.toString());
        }

    }
}
