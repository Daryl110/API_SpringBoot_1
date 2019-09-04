package edu.eam.ejemplo.service;

import edu.eam.ejemplo.model.User;
import edu.eam.ejemplo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list(){
        return this.userRepository.list();
    }

    public User create(User user){
        if (user.getName() == null)return null;
        if(this.userRepository.create(user))return user;
        return null;
    }

    public User update(String name, User user) {
        User user1 = this.find(name);
        if (user1 == null) return null;
        if (this.userRepository.update(user1, user))return user1;
        return null;
    }

    public User delete(String name){
        User user = this.userRepository.find(name);
        if (user == null) return null;
        if (this.userRepository.delete(user))return user;
        return null;
    }

    public User find(String name){
        return this.userRepository.find(name);
    }
}
