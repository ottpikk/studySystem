package com.sda.studysystem.services;

import com.sda.studysystem.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle user related operations
 *
 * @author Ott Pikk
 */

public interface UserService {
    /**
     * To create a new user
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To find user by userName
     *
     * @param userName userName
     * @return Optional of User
     */
    Optional<User> findUserByUserName(String userName);

    /**
     * To find user by username and password
     *
     * @param userName userName
     * @param password password
     * @return Optional of User
     */
    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    /**
     * To find all users
     *
     * @return list of users
     */
    List<User> findAllUsers();

}
