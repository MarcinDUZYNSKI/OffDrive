package pl.pojechali.offdrive.security;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
//  @EnableGlobalMethodSecurity(securedEnabled = true)  // wymagane do włączenia zabezpieczenia na poziomie metod
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SpringDataUserDetailsService userDetailsService;

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("{noop}user123").roles("USER")
//                .and()
//                .withUser("admin1").password("{noop}admin123").roles("ADMIN");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/home").permitAll()
                .antMatchers("/index").authenticated()
                //.antMatchers("/admin/**").hasRole("ADMIN")  //dostęp dla roli admina do serwisu /admin/**
                //.antMatchers("/about/**").hasAnyRole("USER", "ADMIN") // dostęp dla wszystkich ról
                .and().formLogin()
                .loginPage("/login").permitAll()//adres url do strony logowania
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/index",true) // czy to zawsze przenosi po zalogowaniu bez względu jak jest w controlerze??
                .failureUrl("/403")
                .and().logout().logoutSuccessUrl("/home") //akcja przeniesie po wylogowaniu pod wskazany adres
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/admin/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
