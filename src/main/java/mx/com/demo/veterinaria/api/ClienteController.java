package mx.com.demo.veterinaria.api;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;

import mx.com.demo.veterinaria.model.PropietarioModel;  

@RestController  
public class ClienteController   
{  
	@RequestMapping(method=RequestMethod.GET, path="/alta-propietario")  
	public String alta(PropietarioModel model)  
	{  
		return "OK";  
	}  
	
}  
