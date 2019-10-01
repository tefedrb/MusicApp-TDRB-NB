package MusicApp.service;

import MusicApp.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Iterable<User> listUsers();
    public User createUser(User newUser);
    public User login(String username, String password);
    public HttpStatus deleteById(Long userId);
    public User getUser(String username);
    public User addSong(String username, int songId);
}


