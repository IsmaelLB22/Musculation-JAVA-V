package be.helb.service;

import be.helb.DAO.UserDao;
import be.helb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void signUpToDb(User user, BCryptPasswordEncoder bCryptPasswordEncoder) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public void updateProfilePicture(byte[] image) {
        String author = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(author);
        user.setProfilePicture(image);
        userDao.save(user);
    }

    public List<User> getAllUser() {
        return userDao.findAll();
    }
}
