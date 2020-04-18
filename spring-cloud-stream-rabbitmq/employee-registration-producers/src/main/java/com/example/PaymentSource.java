package com.example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentSource {
	// Defines methods for sending messages.
	@Output("paymentChannel")
	MessageChannel paymentChannel();
}
