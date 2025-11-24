package org.sid.customerservice;

import org.sid.customerservice.config.CustomerConfigParams;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("John Doe")
                    .email("john.doe@example.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("oussama")
                    .email("oussama@example.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("abdo")
                    .email("abdo@example.com")
                    .build());
            customerRepository.findAll().forEach(
                    c -> {
                        System.out.println("===============");
                        System.out.println(c.getId());
                        System.out.println(c.getName());
                        System.out.println(c.getEmail());
                    });
        };
    }
}
