package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.servicio.BlogService;
import com.example.demo.modelo.Blog;
import java.util.List;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> consulta() {
		return new ResponseEntity<List<Blog>>(blogService.consulta(), HttpStatus.OK);
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)

	public ResponseEntity<Blog> consultaPorId(@PathVariable("id") long id) {
		return new ResponseEntity<Blog>(blogService.getBlogById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ResponseEntity<Blog> registro(@RequestBody Blog blog) {
		return new ResponseEntity<Blog>(blogService.registro(blog), HttpStatus.OK);
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> actualizar(@RequestBody Blog blog) {

		return new ResponseEntity<Blog>(blogService.registro(blog), HttpStatus.OK);
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminar(@PathVariable("id") long id) {
		Blog blog = blogService.getBlogById(id);
		blogService.eliminar(blog);
		return new ResponseEntity<String>("Blog elininado", HttpStatus.OK);
	}

}
