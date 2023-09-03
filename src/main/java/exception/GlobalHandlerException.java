package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> productNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductsAlreadyExistsException.class)
	public ResponseEntity<?> ProductAlreadyExistsException(Exception e){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> idNotValidException(Exception e){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<?> ClienteNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ClienteAlreadyExistsException.class)
	public ResponseEntity<?> ClienteAlreadyExistsException(Exception e){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.CONFLICT);
	}

}
