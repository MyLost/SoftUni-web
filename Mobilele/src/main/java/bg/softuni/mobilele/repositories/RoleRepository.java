package bg.softuni.mobilele.repositories;


import bg.softuni.mobilele.domain.entities.UserRole;
import bg.softuni.mobilele.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByRole(Role role);
}