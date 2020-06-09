package softuni.workshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .cors().disable()
            .csrf().disable()
                //Requests where authorization will be provided
             .authorizeRequests()
                // /js/** and /css/** means to permit all for all folders on this path
            .antMatchers("/js/**", "/css/**").permitAll()
                // Which requests are accessible from anonymous users (without registration for example...)
            .antMatchers("/", "/users/register", "/users/login").anonymous()
                // Any other request must be authenticated
            .anyRequest().authenticated()
            .and()
            .formLogin()
                // The path where the login form is.
                // And on this request, there will be postRequest -> Post login
                // Therefore we should give the following parameters - username and password.
            .loginPage("/users/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/home")
            .and()
            .logout()
            .logoutSuccessUrl("/");

        /*
        http
           .cors().disable()
            .csrf().disable()
             .authorizeRequests()
            .antMatchers("/js/**", "/css/**").permitAll()
            .antMatchers("/", "/users/register", "/users/login").anonymous()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/users/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/home")
            .and()
            .logout()
            .logoutSuccessUrl("/");
         */


    }
}
