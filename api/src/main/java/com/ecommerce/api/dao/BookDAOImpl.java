package com.ecommerce.api.dao;

import com.ecommerce.api.mapper.BookMapper;
import com.ecommerce.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAOImpl implements BookDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Book> getBooks() {
        String query="SELECT * FROM BOOKS";
        List<Book> books=jdbcTemplate.query(query,new BookMapper());
        return books;
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        String query="SELECT * FROM BOOKS WHERE ISBN="+isbn;
        List<Book> books=jdbcTemplate.query(query,new BookMapper());
        return books.size()>0 ? books.get(0): null;
    }

    @Override
    public List<Book> getBookByName(String name) {
        String query="SELECT * FROM BOOKS WHERE BOOK_NAME='"+name+"'";
        List<Book> books=jdbcTemplate.query(query,new BookMapper());
        return books;
    }

    @Override
    public List<Book> addBook(Book book) {
        String query="INSERT INTO BOOKS (ISBN,BOOK_NAME,AUTHOR,ORIGINAL_STOCK,IN_STOCK,LAST_UPDATED_DATE) VALUES (?,?,?,?,?,?);";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,book.getIsbn());
                ps.setString(2,book.getBookName());
                ps.setString(3,book.getAuthor());
                ps.setInt(4,book.getOriginalStock());
                ps.setInt(5,book.getInStock());
                ps.setString(6,"29-07-2022");
            }
        });
        return getBooks();
    }

    @Override
    public List<Book> incrementStock(Book book) {
        String query="UPDATE BOOKS SET BOOK_NAME=?,AUTHOR=?,ORIGINAL_STOCK=?,IN_STOCK=?,LAST_UPDATED_DATE=? WHERE ISBN=?";
        int count=jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,book.getBookName());
                ps.setString(2,book.getAuthor());
                ps.setInt(3,book.getOriginalStock()+book.getTemporaryStock());
                ps.setInt(4,book.getInStock()+book.getTemporaryStock());
                ps.setString(5,"29-07-2022");
                ps.setInt(6,book.getIsbn());
            }
        });
        return getBooks();
    }
    @Override
    public List<Book> decreaseStock(Book book) {
        String query="UPDATE BOOKS SET BOOK_NAME=?,AUTHOR=?,ORIGINAL_STOCK=?,IN_STOCK=?,LAST_UPDATED_DATE=? WHERE ISBN=?";
        int temporaryStock=book.getTemporaryStock();
        if(temporaryStock>0 && temporaryStock<=book.getInStock()){
            int count=jdbcTemplate.update(query, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,book.getBookName());
                    ps.setString(2,book.getAuthor());
                    ps.setInt(3,book.getOriginalStock()-book.getTemporaryStock());
                    ps.setInt(4,book.getInStock()-book.getTemporaryStock());
                    ps.setString(5,"29-07-2022");
                    ps.setInt(6,book.getIsbn());
                }
            });
            return getBooks();
        }else {
            return new ArrayList<>();
        }
    }
}
