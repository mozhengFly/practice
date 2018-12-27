/**
 * @projectName cache
 * @package com.mozhengfly.cache.business.service
 * @className com.mozhengfly.cache.business.service.UserService
 */

package com.mozhengfly.cache.business.service;

import com.mozhengfly.cache.business.dao.UserDao;
import com.mozhengfly.cache.business.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @Description 用户Service类
 * @Author wangchonglin
 * @Date 2018/12/27 18:01
 * @Version 1.0.2
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 插入User
     * @param user
     */
    public void insertUser(User user) {
        userDao.insert(user);
    }

    /**
     * 删除User
     * @param id
     */
    public void deleteUserById(String id) {
        userDao.deleteById(id);
    }

    /**
     * 更新User
     * @param user
     */
    public void updateUser(User user) {
        userDao.updateById(user);
    }

    /**
     * 查询User
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#p0")
    public User selectUserById(String id) {
        return userDao.selectById(id);
    }


}
