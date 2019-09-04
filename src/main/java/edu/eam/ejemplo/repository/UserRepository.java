package edu.eam.ejemplo.repository;

import edu.eam.ejemplo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();

        this.users.add(new User("NicoCabi", 15));
        this.users.add(new User("QuiramaCabi", 15));
        this.users.add(new User("AlvaroCabi", 15));
        this.users.add(new User("SuazoCabi", 15));
        this.users.add(new User("JohanCabi", 15));
    }

    public List<User> list(){
        return this.users;
    }

    public boolean create(User user){
        return this.users.add(user);
    }

    public boolean update(User user, User user1) {
        try{
            user.setYear(user1.getYear());
        }catch (NullPointerException e){
            return false;
        }
        return true;
    }

    public boolean delete(User user){
        return this.users.remove(user);
    }

    public User find(String name){
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
