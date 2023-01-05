package AllThingsByAV.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(5);

    }
    @Override

    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers( "/category/**").permitAll()
                .antMatchers( "/product/**").permitAll()
                .antMatchers("/adminLogin").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails test = User.builder()
                .username(System.getenv("admin_username"))
                .password(passwordEncoder().encode(System.getenv("admin_password")))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(test);

        return userDetailsManager;

    }
}