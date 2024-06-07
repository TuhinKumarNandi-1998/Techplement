package respositories;

import models.Roles;

import java.util.HashMap;
import java.util.Map;

public class RolesRepository {
    Map<Integer, Roles> rolesDB = new HashMap<>();

    //saving Roles to DB
    int j=1;
    public void saveRolesToDB(Roles roles) {
        roles.setId(j*1L);
        rolesDB.put(j, roles);
        j++;
    }

    //getting Roles from DB
    public Roles getRolesFromDBUsingName(String role) {
        for (Map.Entry<Integer, Roles> entry : rolesDB.entrySet()) {
            int key = entry.getKey();
            Roles roles = entry.getValue();

            if(roles.getRoleName().equalsIgnoreCase(role)) {
                return roles;
            }
        }
        return null;
    }
}
