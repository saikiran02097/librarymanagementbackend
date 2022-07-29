package com.ecommerce.api.mapper;

import com.ecommerce.api.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book b=new Book();
        b.setIsbn(rs.getInt("ISBN"));
        b.setBookName(rs.getString("BOOK_NAME"));
        b.setAuthor(rs.getString("AUTHOR"));
        b.setInStock(rs.getInt("IN_STOCK"));
        b.setOriginalStock(rs.getInt("ORIGINAL_STOCK"));
        b.setLastUpdatedDate(rs.getString("LAST_UPDATED_DATE"));
        return b;
    }
}
