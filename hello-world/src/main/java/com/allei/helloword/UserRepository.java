package com.allei.helloword;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    //模拟数据库存储
    private static Map<Integer,User> userMap = new HashMap<>();

    //初始化仓储数据
    static {
        userMap.put(1,new User(1,"allei",18));
        userMap.put(2,new User(2,"mingli",18));
    }

    public User getUserById(Integer id) {
        return userMap.get(id);
    }

    public User addUser(User user) {
        return userMap.put(user.getId(),user);
    }

    public Collection<User> getUsers() {
        return userMap.values();
    }

}