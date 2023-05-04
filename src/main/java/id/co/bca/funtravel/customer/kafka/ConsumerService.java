package id.co.bca.funtravel.customer.kafka;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bca.funtravel.customer.dto.TransferDTO;
import jakarta.transaction.Transactional;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import id.co.bca.funtravel.customer.model.CustomerModel;
import id.co.bca.funtravel.customer.repository.CustomerRepository;

@Service
@Transactional
public class ConsumerService {
    
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private NewTopic newTopic;

    public ConsumerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "updateBalance", groupId = "funtravel", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransferDTO transferDTO = new TransferDTO();
        try {
            transferDTO = mapper.readValue(message,new TypeReference<TransferDTO>() {});
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //debet balance
        CustomerModel customer = repository.findCustomerById(transferDTO.getIdCustomer());
        customer.setBalance(customer.getBalance() - transferDTO.getTotal());
        repository.save(customer);
        System.out.println("1" + customer + "\n" + transferDTO.getIdCustomer());

        //credit balance to owner
        CustomerModel owner = repository.findCustomerById(1);
        owner.setBalance(owner.getBalance() + transferDTO.getTotal());
        repository.save(owner);
        System.out.println("2" + owner);


    }
}
