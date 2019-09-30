package MusicApp.service;

import MusicApp.models.Course;
import MusicApp.models.User;
import MusicApp.models.UserRole;
import MusicApp.repositories.CourseRepository;
import MusicApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Autowired
    UserRoleService userRoleService;

    @Override
    public User createUser(User newUser){
        UserRole userRole = userRoleService.getRole(newUser.getUserRole().getName());
        newUser.setUserRole(userRole);
        return userRepository.save(newUser);
    }

    @Override
    public User login(String username, String password){
        return userRepository.login(username, password);
    }

    @Override
    public HttpStatus deleteById(Long userId){
        userRepository.deleteById(userId);
        return null;
    }

    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    @Autowired
    CourseRepository courseRepository;

    @Override
    public User addCourse(String username, int courseId) {
        Course course = courseRepository.findById(courseId).get();
        User user = getUser(username);
        user.addCourse(course);

        return userRepository.save(user);
    }

}
