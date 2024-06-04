package services;

import models.Roles;
import models.Users;
import respositories.RolesRepository;
import respositories.UserRepository;

public class UserService {
    private UserRepository userRepository;
    private RolesRepository rolesRepository;

    public UserService(UserRepository userRepository,
                       RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    public void addUser(Users users) {
        if(userRepository.getUserFromDBUsingUserName(users.getName()) != null) {
            //user is already present in DB
        }
        else {
            for(Roles roles : users.getRoles()) {
                if(rolesRepository.getRolesFromDBUsingName(roles.getRoleName())!=null) {
                    //role is already present in DB
                }
                else {
                    rolesRepository.saveRolesToDB(roles);
                }
            }
            userRepository.saveUserToDB(users);
        }
    }

    public void removeUser(String userName) {
        userRepository.deleteUserUsingName(userName);
    }
}
