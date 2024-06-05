package respositories;

import models.Roles;
import models.Users;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    Map<Integer, Users> userDB = new HashMap<>();

    //saving Users to DB
    int i=1;
    public void saveUserToDB(Users users) {
        users.setId(i*1L);
        userDB.put(i, users);
        i++;
    }

    //getting Users from DB
    public Users getUserFromDBUsingUserName(String name) {
        for (Map.Entry<Integer, Users> entry : userDB.entrySet()) {
            int key = entry.getKey();
            Users users = entry.getValue();

            if(users.getName().equals(name)) {
                return users;
            }
        }

        return null;
    }

    //Removing user from DB
    public void deleteUserUsingName(String userName) {
        for (Map.Entry<Integer, Users> entry : userDB.entrySet()) {
            int key = entry.getKey();
            Users users = entry.getValue();

            if(users.getName().equals(userName)) {
                //I have to remove it
                userDB.remove(key);
            }
        }
    }
}
