package com.cbfacademy.restapiexercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping
	public String Ping() {
		return "Ping";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

}

public class IOU {
		public String Name;
		public BigDecimal amount;
}