package com.example.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Cheque;
import com.example.entities.CreditCard;
import com.example.repos.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPaymentWithCard() {
		CreditCard creditCard=new CreditCard();
		creditCard.setId(100);
		creditCard.setCardnumber("X890678");
		creditCard.setAmount(1000);
		paymentRepository.save(creditCard);
	}
	
	@Test
	public void createPaymentWithCheque() {
		Cheque cheque=new Cheque();
		cheque.setId(200);
		cheque.setChecknumber("NM786F09N");
		cheque.setAmount(86898);
		paymentRepository.save(cheque);
	}

}
