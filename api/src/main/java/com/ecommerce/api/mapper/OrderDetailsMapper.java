package com.ecommerce.api.mapper;

import com.ecommerce.api.model.Book;
import com.ecommerce.api.model.BookOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsMapper implements RowMapper<BookOrder> {

    @Override
    public BookOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookOrder b=new BookOrder();
        b.setIsbn(rs.getInt("ISBN"));
        b.setStudentId(rs.getInt("STUDENT_ID"));
        b.setIssuedBy(rs.getString("ISSUED_BY"));
        b.setIssueDate(rs.getString("ISSUED_DATE"));
        b.setPenalty(rs.getInt("PENALTY"));
        b.setStatus(rs.getString("STATUS"));
        b.setLastUpdatedDate(rs.getString("LAST_UPDATED_DATE"));
        return b;
    }
}
