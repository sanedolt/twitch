package com.laioffer.twitcher.service;

import com.laioffer.twitcher.dao.RegisterDao;
import com.laioffer.twitcher.entity.db.User;
import com.laioffer.twitcher.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(),user.getPassword()));
        return registerDao.register(user);
    }
}

