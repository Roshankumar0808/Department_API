package com.DepartmentAPI.DepartmentAPI;

import jakarta.validation.constraints.Digits;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
public class DepartmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApiApplication.class, args);
	}

//	@SpringBootApplication: Main annotation to mark Spring Boot application entry point, combines @Configuration, @EnableAutoConfiguration, and @ComponentScan
//	@Builder: Lombok annotation that generates a builder pattern for object creation
//	@Data: Lombok shortcut that adds getters, setters, toString, equals, and hashCode methods
//	@Digits: Validates that a number's value has specific number of integer and fractional digits
//	@ExceptionHandler: Marks a method to handle specific exceptions thrown from controller methods
//	@RestControllerAdvice: Enables handling exceptions globally across all @RestController classes
//	@RestController: Combines @Controller and @ResponseBody, indicates class handles REST requests and responses are automatically serialized to JSON/XML

//
//	Component Scanning Flow:
//
//	@SpringBootApplication starts scanning from its package and sub-packages
//	First scans configuration classes (@Configuration)
//	Then scans components in order:
//
//	@Component (basic components)
//	@Repository (data layer)
//	@Service (business layer)
//	@Controller/@RestController (web layer)
//	@RestControllerAdvice/@ControllerAdvice (exception handlers)
//
//
//
//	Exception Handling Priority:
//
//	Most specific @ExceptionHandler in the current controller takes highest priority
//	@RestControllerAdvice with @ExceptionHandler takes second priority
//
//	This is because @RestControllerAdvice is global and handles exceptions across all controllers
//	Spring follows the principle of "most specific wins"
//
//
//	Your custom exception handlers in controllers get precedence over global ones IF:
//
//	They handle the exact exception type or a more specific subclass
//	They are in the same controller where exception occurred
//
//
//
//	Key Point: If you want your custom exception handler to take priority over @RestControllerAdvice, you should:
//
//	Define it in the specific controller where exception might occur
//	Use exact exception type match rather than parent exception classes
//	Use @ExceptionHandler with specific exception class: @ExceptionHandler(YourSpecificException.class)



}
