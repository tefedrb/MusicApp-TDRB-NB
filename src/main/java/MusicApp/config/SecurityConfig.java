package MusicApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


// Configuration is an analog for xml file. Used to configure our app with security features
@Configuration
// This allows Spring to find configuration class and automatically apply the class to the global WebSecurity.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(users.username("test").password("test").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .and()
                .httpBasic();
    }

}