package com.ecommerce.api.dao;

import com.ecommerce.api.model.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getBooks();
    public List<Book> addBook(Book book);
    public List<Book> incrementStock(Book book);
    public List<Book> decreaseStock(Book book);
    public Book getBookByIsbn(int isbn);
    public List<Book> getBookByName(String name);
}
