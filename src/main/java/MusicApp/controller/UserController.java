package MusicApp.controller;

import MusicApp.models.JwtResponse;
import MusicApp.models.User;
import MusicApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/user/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Return Hello World 40";
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @DeleteMapping("/admin/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }

    //addSong is creating a song.
    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String username, @PathVariable int songId){
        return userService.addSong(username, songId);
    }
}
