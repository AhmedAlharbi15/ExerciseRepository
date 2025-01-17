package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);

    @Query("select users from User users where users.username=?1 and users.password=?2")
    User checkuser(String username, String password);

    User findUserByEmail(String email);
    List<User> findUserByAgeGreaterThanEqual(Integer age);

    List<User> findUserByRole(String role);




}
