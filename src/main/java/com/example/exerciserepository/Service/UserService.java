package com.example.exerciserepository.Service;

import com.example.exerciserepository.APi.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getalluser(){
        return userRepository.findAll();
    }
    public void adduser(User user)
    {
        userRepository.save(user);

    }
    public void updateUser(Integer id, User user){
        User user1 = userRepository.findUserById(id);
        if (user1 == null){
            throw new ApiException("wrong User");
        }
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        userRepository.save(user1);
    }
    public void deleteuser(Integer id){
        User user = userRepository.findUserById(id);
        if (id == null){
            throw new ApiException("wrong id");
        }
        userRepository.delete(user);
    }
    public User checkuser(String username, String pssword){
        User user1 = userRepository.checkuser(username, pssword);
        if (user1 == null){
            throw new ApiException("wrong");
        }
        return user1;
    }

    public User findUserByEmail(String email){
        User user1 = userRepository.findUserByEmail(email);
        if (email == null){
            throw new ApiException("wrong");
        }
        return user1;
    }
    public List<User> findUserByRole(String role){
        List<User> user1 = userRepository.findUserByRole(role);
        if (user1.isEmpty()){
            throw new ApiException("wrong");
        }
        return user1;
    }

    public List<User> findUsersByAge(Integer age){
        List<User> user1 = userRepository.findUserByAgeGreaterThanEqual(age);
        if (user1.isEmpty()){
            throw new ApiException("wrong");
        }
        return user1;
    }

}
