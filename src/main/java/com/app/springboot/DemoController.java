package com.app.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

	 @Autowired
	 DemoRespository demoRespository;

	    @GetMapping("/demo")
	    public List<Demo> index(){
	        return demoRespository.findAll();
	    }



	    @PostMapping("/demo/search")
	    public List<Demo> search(@RequestBody Map<String, String> body){
	        String searchTerm = body.get("text");
	        return demoRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
	    }

	    @PostMapping("/demo")
	    public Demo create(@RequestBody Map<String, String> body){
	        String title = body.get("title");
	        String content = body.get("content");
	        return demoRespository.save(new Demo(title, content));
	    }

	

	    @DeleteMapping("demo/{id}")
	    public boolean delete(@PathVariable String id){
	        int blogId = Integer.parseInt(id);
	        demoRespository.deleteById(blogId);
	        return true;
	    }
	    
	    
	    @PostMapping("demo/id")
	    public void deleteUpdate(@PathVariable String id)
	    {
	    	
	    }
	    
	// Best practices to follow in the development with 12 factors development
//  1. Codebase - version control system and the code management
//	2. Dependency management allows all the required mvn dependencies.
//	3. Configurarion management that allows the required configs specified in a YAML file.
//	4. Backing services or the Database repository management.
//	5. Build release and running the application
//	6. Port binding of the application
//	7. Portability
//	8. concurrency
//	9. dev/ prod environment
//	10. logs
//	11. admin process
//	12. Process

	}