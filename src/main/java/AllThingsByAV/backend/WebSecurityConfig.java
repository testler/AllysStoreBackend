package AllThingsByAV.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@ComponentScan("AllThingsByAv.backend")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public InMemoryUserDetailsManager UserDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("${admin_username}").password("${admin_password}").roles("ADMIN").build());
        return manager;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/product","/Category","/checkout").permitAll()
                .antMatchers("/admin").authenticated()
                .and()
                .headers()
                .and()
                .logout();
    }

}
