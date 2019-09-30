package MusicApp.service;

import MusicApp.models.User;
import org.springframework.http.HttpStatus;

public interface UserService {
    public Iterable<User> listUsers();
    public User createUser(User newUser);
    public User login(String username, String password);
    public HttpStatus deleteById(Long userId);
    public User getUser(String username);
    public User addCourse(String username, int courseId);
}


