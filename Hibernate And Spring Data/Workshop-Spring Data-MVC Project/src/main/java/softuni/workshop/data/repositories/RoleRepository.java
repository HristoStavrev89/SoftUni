package softuni.workshop.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.workshop.data.entities.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {


    Role findByAuthority(String role);



}
