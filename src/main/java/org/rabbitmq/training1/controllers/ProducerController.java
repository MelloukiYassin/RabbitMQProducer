package org.rabbitmq.training1.controllers;

import org.rabbitmq.training1.entities.Scholar;
import org.rabbitmq.training1.json.Student;
import org.rabbitmq.training1.producer.IProducer;
import org.rabbitmq.training1.repositories.ScholarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private IProducer producer;

    private ScholarRepository scholarRepository;

    public ProducerController(IProducer producer, ScholarRepository scholarRepository) {
        this.producer = producer;
        this.scholarRepository = scholarRepository;
    }

    @GetMapping("/send")
    public String sendMessage(Student  message){
        Student student = Student.builder().name("Mohamed").firstname("MELLOUKI").age(61).build();
        Scholar scholar = Scholar.builder().name(student.getName()).firstname(student.getFirstname()).age(student.getAge()).build();
        this.scholarRepository.save(scholar);
        producer.produceMessage(student);
        return student.toString();
    }

    @PostMapping("/save")
    public ResponseEntity saveAndSendStudent(@RequestBody Student student){
        if(student == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Object student cannot be null");
        }
        Scholar scholar = Scholar.builder().name(student.getName()).firstname(student.getFirstname()).age(student.getAge()).build();
        this.scholarRepository.save(scholar);
        producer.produceMessage(student);
        return ResponseEntity.ok(student);
    }
}
