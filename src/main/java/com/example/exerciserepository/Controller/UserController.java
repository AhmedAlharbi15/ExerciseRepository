package com.example.exerciserepository.Controller;

import com.example.exerciserepository.APi.Api;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAlluser() {
        return ResponseEntity.status(200).body(userService.getalluser());
    }
    @PostMapping("/add")
    public ResponseEntity addemp(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        userService.adduser(user);
        return ResponseEntity.status(200).body(new Api("User added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity upuser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new Api("Update user"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteuser(@PathVariable Integer id){
        userService.deleteuser(id);
        return ResponseEntity.status(200).body(new Api("Delete user"));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity email (@PathVariable String email){
        User u = userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(u);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity findUserByRole(@PathVariable String role){
        List<User> u = userService.findUserByRole(role);
        return ResponseEntity.status(200).body(u);
    }


    @GetMapping("/age/{age}")
    public ResponseEntity findUsersByAge(@PathVariable Integer age){
        List<User> u = userService.findUsersByAge(age);
        return ResponseEntity.status(200).body(u);
    }
}