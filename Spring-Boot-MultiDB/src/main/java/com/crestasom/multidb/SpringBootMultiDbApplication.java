package com.crestasom.multidb;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.book.model.Book;
import com.crestasom.multidb.book.model.Copy;
import com.crestasom.multidb.book.repo.BookRepo;
import com.crestasom.multidb.book.repo.CopyRepo;
import com.crestasom.multidb.service.BookService;
import com.crestasom.multidb.service.CopyService;
import com.crestasom.multidb.service.UserService;
import com.crestasom.multidb.user.model.User;
import com.crestasom.multidb.user.repo.UserBeanRepo;

@SpringBootApplication
@RestController

public class SpringBootMultiDbApplication {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private CopyService copyService;

	@PostConstruct
	public void add2Db() {

		/*
		 * userRepo.saveAll(Stream.of(new User(244, "Ram"), new User(245,
		 * "Ram")).collect(Collectors.toList())); bookRepo.saveAll(Stream.of(new
		 * Book(244, "Java"), new Book(245, "C#")).collect(Collectors.toList()));
		 * copyRepo.saveAll(Stream.of(new Copy(244, "Java"), new Copy(245,
		 * "C#")).collect(Collectors.toList()));
		 */

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDbApplication.class, args);
	}

	@RequestMapping("/copies")
	public List<Copy> getAllCopies() {
		return copyService.getAllCopies();
	}

	@RequestMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
