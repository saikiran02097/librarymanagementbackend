package com.ecommerce.api.dao;

import com.ecommerce.api.mapper.BookMapper;
import com.ecommerce.api.mapper.OrderDetailsMapper;
import com.ecommerce.api.model.Book;
import com.ecommerce.api.model.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class BookOrderDAOImpl implements BookOrderDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public String issueBook(BookOrder bookOrder) {
        String query="INSERT INTO ORDERDETAILS (ISBN,STUDENT_ID,ISSUED_BY,ISSUED_DATE,PENALTY,STATUS,LAST_UPDATED_DATE) VALUES (?,?,?,?,?,?,?);";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,bookOrder.getIsbn());
                ps.setInt(2,bookOrder.getStudentId());
                ps.setString(3,bookOrder.getIssuedBy());
                ps.setString(4,bookOrder.getIssueDate());
                ps.setInt(5,0);
                ps.setString(6,"issued");
                ps.setString(7,"29-07-2022");
            }
        });
        String updateInStockQuery="UPDATE BOOKS SET IN_STOCK=?,LAST_UPDATED_DATE=? WHERE ISBN=?";
        jdbcTemplate.update(updateInStockQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,bookOrder.getInStock()-1);
                ps.setString(2,"29-07-2022");
                ps.setInt(3,bookOrder.getIsbn());
            }
        });

        return "Book Issued Successfully";
    }

    @Override
    public String collectBook(BookOrder bookOrder) {
        String query="UPDATE ORDERDETAILS SET STATUS=? WHERE ISBN=? AND STUDENT_ID=?;";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,"collected");
                ps.setInt(2,bookOrder.getIsbn());
                ps.setInt(3,bookOrder.getStudentId());
            }
        });
        String updateInStockQuery="UPDATE BOOKS SET IN_STOCK=?,LAST_UPDATED_DATE=? WHERE ISBN=?";
        jdbcTemplate.update(updateInStockQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,bookOrder.getInStock()+1);
                ps.setString(2,"29-07-2022");
                ps.setInt(3,bookOrder.getIsbn());
            }
        });

        return "Book Collected Successfully";
    }

    @Override
    public List<BookOrder> getStudentBooks(int id,String status) {
        String query="SELECT * FROM ORDERDETAILS WHERE STUDENT_ID="+id+" AND STATUS='"+status+"'";
        List<BookOrder> orders=jdbcTemplate.query(query,new OrderDetailsMapper());
        return orders;
    }
}
