package in.srikanth.EmployeeAuthentication.repository;

import in.srikanth.EmployeeAuthentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
