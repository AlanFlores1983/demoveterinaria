package mx.com.demo.veterinaria.api;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  

@RestController  
public class VeterinarioController   
{  
	@RequestMapping(method=RequestMethod.GET, path="/alta-veterinario")  
	public String alta()  
	{  
		return "OK";  
	}  
	
}  
