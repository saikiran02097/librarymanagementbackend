package com.ecommerce.api.controllers;

import com.ecommerce.api.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDAOImpl userDAOImpl;

    @PostMapping("disableUser/{ID}")
    public ResponseEntity<String> disableUser(@PathVariable("ID") int ID){
        String result=userDAOImpl.disableUser(ID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    };
}
