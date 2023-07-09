package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static final List<User1> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User1(1, "Kenneth", new Date(), "pass1", "701010-1111111"));
        users.add(new User1(2, "Alice", new Date(), "pass2", "801010-2222222"));
        users.add(new User1(3, "Elena", new Date(), "pass3", "901010-1111111"));
    }

    public List<User1> findAll() {
        return users;
    }

    public User1 save(User1 user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User1 findOne(int id) {
        for (User1 user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User1 deleteById(int id) {
        Iterator<User1> iterator = users.iterator();
        while (iterator.hasNext()) {
            User1 user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
