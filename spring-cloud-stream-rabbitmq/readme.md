PaymentConsumerApplication.java

```
@EnableBinding(Sink.class)
@SpringBootApplication
public class PaymentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentConsumerApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(@Payload Payment payment) {
		System.out.println("Employees Registered by Client " + payment);
	}
}

```
