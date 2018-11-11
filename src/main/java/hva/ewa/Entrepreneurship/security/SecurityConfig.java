package hva.ewa.Entrepreneurship.security;

import hva.ewa.Entrepreneurship.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //attributes
    private final CustomUserDetailsService customUserDetailsService;
    private static String REALM = "TEST_REALM";

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    //Constructor returns details of user
    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Overrides existing method of the WebSecurityConfigurerAdapters interface so that http access
     * can be altered.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/*/users").permitAll()
                //.anyRequest().authenticated()
//                .antMatchers("/*/enterStudent").hasRole("Student")
//                .antMatchers("/*/enterTeacher").hasRole("Teacher")
                .and()
                .addFilter(new TokenAuthenticationFilter(authenticationManager()))
                .addFilter(new TokenAuthorizationFilter(authenticationManager(), customUserDetailsService));
//              .httpBasic()
//              .realmName(REALM)
//              .authenticationEntryPoint(getBasicAuthEntryPoint());

    }

//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }


    /**
     * Instantiates the CustomBasicAuthenticationEntryPoint class so any customized http status code
     * can be returned with its designated message.
     *
     * @return instantiation of the CustomBasicAuthenticationEntryPoint class
     */
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }
}
