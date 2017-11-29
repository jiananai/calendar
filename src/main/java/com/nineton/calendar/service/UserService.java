package com.nineton.calendar.service;



import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.User;
import com.nineton.calendar.pojo.UserExt;

import java.text.ParseException;
import java.util.Date;

public interface UserService {

    UserExt insertOrFindUser(User user);

    User selectByPrimaryKey(String identificationCode);

    void update(User user);

    PageResult findAllUser(Integer page, Integer limit, User user);

    void deleteUser(String identificationCode);
}
