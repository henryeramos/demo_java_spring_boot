package com.example.demo.servicio;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Blog;
import com.example.demo.repository.BlogRepository;
import java.util.List;
@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	
	public List<Blog> consulta(){
		return blogRepository.findAll();
	}
	
	public Blog getBlogById(long id){
		return blogRepository.findById(id).orElse(null);
	}
	
	public Blog registro(Blog blog) {
		return blogRepository.save(blog);
	}
	
	public void eliminar(Blog blog) {
		blogRepository.delete(blog);
		
	}
}
