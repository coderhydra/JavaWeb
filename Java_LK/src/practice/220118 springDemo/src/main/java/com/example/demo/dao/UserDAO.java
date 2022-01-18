package com.example.demo.dao;

import java.util.ArrayList;

import com.example.demo.vo.User;

public interface UserDAO {
   
   boolean insert(User u);
   int insertAndGetId(User u);
   User select(int num);
   boolean update(User u);
   boolean delete(int num);
   ArrayList<User> getList();
}