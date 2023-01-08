package be.helb.controller;

import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.model.User;
import be.helb.model.Workout;
import be.helb.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    @ApiOperation(value = "Create a new account")
    public void signUp(@RequestBody User user){
        userService.signUpToDb(user, bCryptPasswordEncoder);
    }

    @PutMapping("/Update Profile Picture")
    @ApiOperation(value = "Update your profile picture")
    public void updateProfilePicture(@RequestParam byte[] image) {
        userService.updateProfilePicture(image);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login")
    public void theFakeLogin(@RequestBody User loginRequestModel){
        throw new IllegalStateException("Error");
    }
}
