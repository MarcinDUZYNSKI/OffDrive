package pl.pojechali.offdrive.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pojechali.offdrive.user.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
//  @EnableGlobalMethodSecurity(securedEnabled = true)  // wymagane do włączenia zabezpieczenia na poziomie metod
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("{noop}user123").roles("USER")
                .and()
                .withUser("admin1").password("{noop}admin123").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/about").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")  //dostęp dla roli admina do serwisu /admin/**
                .antMatchers("/about/**").hasAnyRole("USER", "ADMIN") // dostęp dla wszystkich ról
                .and().formLogin()
                .loginPage("/login")//adres url do strony logowania
                .and().logout().logoutSuccessUrl("/") //akcja przenieśe po wylogowaniu pod wskazany adres
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

}
