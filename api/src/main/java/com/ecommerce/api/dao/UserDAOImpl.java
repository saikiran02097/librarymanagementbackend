package com.ecommerce.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserDAOImpl implements UserDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String disableUser(int ID) {
        String query="UPDATE USERS SET IS_ACTIVE=? AND LAST_UPDATED_DATE=? WHERE ID=?";
        int rowsUpdated=jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,"N");
                ps.setString(2,"29-07-2022");
                ps.setInt(3,ID);
            }
        });

        return rowsUpdated>0?"id "+ID+" disabled successfully":"failed to update";
    }
}
