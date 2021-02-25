package com.example.demo.Book;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController{
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
//		Book obj[] = new Book[2];
//		obj[0] = new Book(1l,"Mastering in SpringBoot", "Rupali");
//		obj[1] = new Book(1l,"Mastering in SpringBoot", "Manish");
//		return Arrays.asList(obj);
		return Arrays.asList(new Book(1l,"Mastering in SpringBoot", "Rupali"));
	}
	@PostMapping("/books")
	public List <Book> getBook(){
		return Arrays.asList(new Book(1l,"Mastering in JPA", "Manish"));
	}
}
