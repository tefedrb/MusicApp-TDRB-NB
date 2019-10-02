package MusicApp.config;

import MusicApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // is an analog for XML files, which is used to configure our application with Security features
@EnableWebSecurity // allows Spring to find configuration class and apply it to global WebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { // WebSecurityConfigurerAdapter enable;es HTTP security in our app

    @Autowired
    UserService userService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter; // Authenticate whether the user exists or not.

    @Bean("encoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        antMatchers() allows configuring the HttpSecurity to only be invoked when matching the provided ant pattern.
//        csrf() stands for cross site forgery, which can steal user so we encrypt it
//authentication states that anything inside of it such as user or profile if you put / then anything afterwards needs authentication
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/signup/**", "/login/**").permitAll()
                .antMatchers("/user/**", "/profile/**", "/song/**").authenticated()
                .antMatchers("/role/**").hasRole("ADMIN")
                .and()
                .httpBasic();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
//Here we are hardcoding, so that way through postman we could use the test and
//password ins postman under Auth(Basic Auth) and add the role ADMIN to our database.
//Basic Auth is used when there is no data to begin with.
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
//just creating the type of role a user could have (We should never do this cuz it allows people see it)
        auth.inMemoryAuthentication().withUser("test").password(encoder().encode("test")).roles("ADMIN");
    }
}