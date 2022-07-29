package com.ecommerce.api.dao;

import com.ecommerce.api.model.BookOrder;

import java.util.List;

public interface BookOrderDAO {
    public String issueBook(BookOrder bookOrder);
    public String collectBook(BookOrder bookOrder);
    public List<BookOrder> getStudentBooks(int id,String status);
}
