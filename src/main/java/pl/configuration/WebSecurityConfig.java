package pl.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                // tutaj są URL wymagające autoryzacji - strefa chroniona
                        //   .antMatchers(/url) -> wymaga autoryzacji
                // .hasAnyAuthority("uprawnienie") -> dla określonego uprawnienia
                    .antMatchers("/").hasAnyAuthority("manager", "technician","tester","warehouseman")
                    .antMatchers("/diagnostic").hasAnyAuthority("manager", "technician","tester","warehouseman")
                    .antMatchers("/tableAllProducts").hasAnyAuthority("manager", "technician","tester","warehouseman")
                    .antMatchers("/productregister").hasAnyAuthority("manager", "technician","tester","warehouseman")
                    .antMatchers("/register").hasAnyAuthority("manager", "technician","tester","warehouseman")
                // pozostałe URL udostępnij dla każdego
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                // formularz logowania
                .formLogin()
                // adres formularza logowania
                .loginPage("/login")
                // nazwa pola w formularzu dot. loginu
                .usernameParameter("login")
                // nazwa pola w formularzu dot. hasła
                .passwordParameter("password")
                // adres gdzie przekazywane są parametry formularza
                .loginProcessingUrl("/login-process")
                // domyśly URL po poprawnym zalogowaniu
                .defaultSuccessUrl("/")
                // domyśly URL po błędnym logowaniu
                .failureUrl("/errorPage")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                .jdbcAuthentication()
                // SQL dla logowania użytkownika po adresie login i haśle
                        .usersByUsernameQuery("SELECT e.login, e.password, e.active FROM employee e WHERE e.login = ?")
                // SQL dla przypisania uprawnień dla zalogowanego użytkownika
                .authoritiesByUsernameQuery("SELECT e.login, r.role FROM employee e JOIN employee_role er ON er.user_id = e.id JOIN role r ON er.role_id = r.id WHERE e.login = ?")
                // wynik logowania
                .dataSource(dataSource)
                // szyfrowanie hasła
                .passwordEncoder(bCryptPasswordEncoder);
    }

}
