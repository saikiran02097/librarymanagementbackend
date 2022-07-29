package com.ecommerce.api.controllers;

import com.ecommerce.api.dao.BookDAOImpl;
import com.ecommerce.api.dao.BookOrderDAOImpl;
import com.ecommerce.api.model.Book;
import com.ecommerce.api.model.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class BookOrderController {

    @Autowired
    private BookOrderDAOImpl bookOrderDAOImpl;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody BookOrder bookOrder){
        return bookOrderDAOImpl.issueBook(bookOrder);
    }
    @PostMapping("/collectBook")
    public String collectBook(@RequestBody BookOrder bookOrder){
        return bookOrderDAOImpl.collectBook(bookOrder);
    }

    @GetMapping("/getStudentHistory/{ID}/{Status}")
    public List<BookOrder> getStudentBooks(@PathVariable("ID") int ID,@PathVariable("Status") String Status){
        return bookOrderDAOImpl.getStudentBooks(ID,Status);
    }
}
