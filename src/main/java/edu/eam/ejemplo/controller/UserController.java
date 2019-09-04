package edu.eam.ejemplo.controller;

import edu.eam.ejemplo.model.User;
import edu.eam.ejemplo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(this.userService.list());
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody User user){
        user = this.userService.create(user);
        if (user == null)return new ResponseEntity<>(
                "El nombre del usuario no puede ser nulo",
                HttpStatus.BAD_REQUEST
        );
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{name}")
    public ResponseEntity<Object> update(@PathVariable("name") String name, @Valid @RequestBody User user) {
        user = this.userService.update(name, user);
        if (user == null)return new ResponseEntity<>(
                "No se ha encontrado el usuario con ese nombre",
                HttpStatus.BAD_REQUEST
        );
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Object> delete(@PathVariable("name") String name){
        User user = this.userService.delete(name);
        if (user == null)return new ResponseEntity<>(
                "No se ha encontrado el usuario con ese nombre",
                HttpStatus.BAD_REQUEST
        );
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> find(@PathVariable("name") String name){
        User user = this.userService.find(name);
        if (user == null)return new ResponseEntity<>(
                "No se ha encontrado el usuario con ese nombre",
                HttpStatus.BAD_REQUEST
        );
        return ResponseEntity.ok(user);
    }
}
