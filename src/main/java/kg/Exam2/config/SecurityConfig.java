package kg.Exam2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .withUser("admin").password("{noop}1234").roles("ADMIN").and()
                .withUser("user").password("{noop}4321").roles("USER");
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        http
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin").hasRole("ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
