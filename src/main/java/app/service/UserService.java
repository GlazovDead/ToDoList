package app.service;

import app.models.Role;
import app.models.User;
import app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    private User user;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }

    public void updateProfile(User user, String name, String password) {
       String userName=user.getUsername();//старые значения полей юзера
       String userPassword=user.getPassword();
       boolean isNameChanged = ((name != null && !name.equals(userName)) || (userName != null && !userName.equals(name)));
       if (isNameChanged){
           user.setUsername(name);
       }
       boolean isPasswordChanged= (password != null && !password.equals(userPassword)) || (userPassword!=null && !userPassword.equals(password));
       if (isPasswordChanged){
           user.setPassword(passwordEncoder.encode(password));
       }
       userRepo.save(user);
    }
}
