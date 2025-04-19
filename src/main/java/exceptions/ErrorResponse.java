package exceptions;

import java.util.List;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import lombok.Data;

@Data

public class ErrorResponse {
	private final int status;
	private final String message;
	private String stackTrace;
	private List<ValidationErrors> errors;

	@Data
	private static class ValidationError {

		private final String field;
		private final String message;

	}

}
