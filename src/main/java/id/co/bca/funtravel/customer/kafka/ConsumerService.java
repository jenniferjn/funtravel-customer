package id.co.bca.funtravel.customer.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import id.co.bca.funtravel.customer.model.CustomerModel;
import id.co.bca.funtravel.customer.repository.CustomerRepository;

@Service
public class ConsumerService {
    
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private NewTopic newTopic;

    public ConsumerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "updateBalance", groupId = "funtravel", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        CustomerModel customer = repository.findCustomerById(1);
        customer.setBalance(customer.getBalance() - Integer.parseInt(message));
        repository.save(customer);
    }
}
