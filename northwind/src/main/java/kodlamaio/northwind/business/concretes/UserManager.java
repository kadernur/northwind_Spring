package kodlamaio.northwind.business.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;


@Service

public class UserManager   implements UserService{

	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi") ;
		
		
		
	}

	
	
	
	@Override
	public DataResult<User> findByEmail(String email) {
		
		
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),
				"Kullanıcı bulundu.");
		
	}

	
	//typeOf() burda .class ile olur.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
	{
		Map<String, String> validationErrors=new HashMap<String, String>();
		
		//field'lerde oluşan hatanın listesi
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors())
		{
			validationErrors.put(fieldError.getField(), 
					fieldError.getDefaultMessage());
			
			
		}
		
		ErrorDataResult<Object> errors=
				new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		
		
		return errors;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
