package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(PaymentSource.class)
public class PaymentController {

	@Autowired
	PaymentSource paymentSource;

	@RequestMapping("/register")
	@ResponseBody
	public String orderFood(@RequestBody Payment payment) {
		paymentSource.paymentChannel().send(MessageBuilder.withPayload(payment).build());
		//System.out.println(payment.toString());
		return "Patment Details Provided";
	}
}