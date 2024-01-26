package net.chris.customerservice;

import net.chris.customerservice.config.GlobalConfig;
import net.chris.customerservice.entities.Customer;
import net.chris.customerservice.repository.CustomerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRespository customerRespository) {
		return args ->{
			List<Customer> customerList = List.of(
				Customer.builder()
						.firstName("Chris")
						.lastName("SEWAH")
						.email("hugsewah@gmail.com")
						.build(),
				Customer.builder()
						.firstName("Hug")
						.lastName("AKUETE-SEWAH")
						.email("huguettesewah@gmail.com")
						.build()

			);
			customerRespository.saveAll(customerList);
		};
	}

}
