package softuni.workshop.service.services;

import softuni.workshop.data.entities.Role;
import softuni.workshop.service.models.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String role);

    Role getByAuthority(String role);
}
