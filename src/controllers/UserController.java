package controllers;

import dtos.UserRequestDTO;
import models.Roles;
import models.Users;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }
    public void addUser(UserRequestDTO userRequestDTO) {
        Users users = new Users();
        users.setName(userRequestDTO.getName());

        List<Roles> roles = new ArrayList<>();
        for (String role : userRequestDTO.getRoles()) {
            roles.add(new Roles(role));
        }
        users.setRoles(roles);
        userService.addUser(users);
    }

    public void removeUser(UserRequestDTO userRequestDTO) {
        userService.removeUser(userRequestDTO.getName());
    }
}
