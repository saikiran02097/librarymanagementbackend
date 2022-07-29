package com.ecommerce.api.controllers;
import com.ecommerce.api.dao.BookDAO;
import com.ecommerce.api.dao.BookDAOImpl;
import com.ecommerce.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookDAOImpl bookDAOImpl;

    @GetMapping
    public List<Book> getBooks(){
        return bookDAOImpl.getBooks();
    }

    @GetMapping("/getBookByISBN/{ISBN}")
    public Book getBookByIsbn(@PathVariable("ISBN") int ISBN){
        return bookDAOImpl.getBookByIsbn(ISBN);
    }

    @GetMapping("/getBookByName/{NAME}")
    public List<Book> getBookByName(@PathVariable("NAME") String NAME){
        return bookDAOImpl.getBookByName(NAME);
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book book){
        return bookDAOImpl.addBook(book);
    }

    @PostMapping("/increaseStock")
    public List<Book> incrementStock(@RequestBody Book book){
        return bookDAOImpl.incrementStock(book);
    }

    @PostMapping("/decreaseStock")
    public List<Book> decreaseStock(@RequestBody Book book){
        return bookDAOImpl.decreaseStock(book);
    }
}
