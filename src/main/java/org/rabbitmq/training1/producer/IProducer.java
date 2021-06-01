package org.rabbitmq.training1.producer;

import org.rabbitmq.training1.json.Student;

public interface IProducer {
    void produceMessage(Student student);
}
