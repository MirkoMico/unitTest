package co.develhope.testController.service;

import co.develhope.testController.entities.User;
import co.develhope.testController.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User>getUsers(){
        return userRepository.findAll();

    }
    public User getSingle(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }
    public User update(long id , User user){
         user.setId(id);
         if (user==null)return null;
         user.setName(user.getName());
         user.setSurname(user.getSurname());
         user.setAge(user.getAge());
         userRepository.save(user);
         return user;
    }
    public User getUserIsActive( boolean isActive){
        Optional<User> optionalUser = userRepository.findByIsActive(isActive);
        if (optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }

}
