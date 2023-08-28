package com.softuni.book.security.config;

import com.softuni.book.model.enums.UserRoleEnum;
import com.softuni.book.repository.UserRepository;
import com.softuni.book.service.ApplicationUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
//        http
//            .authorizeHttpRequests((authorizeHttpRequests) ->
//                // defines which pages will be authorized
//                authorizeHttpRequests
//                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                    .requestMatchers("/", "/users/login", "/users/register").permitAll()
//                    .requestMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name())
//                    .requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name())
//                .anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new ApplicationUserDetailsService(userRepository);
//    }

//    @Bean
//    public SecurityContextRepository securityContextRepository () {
//        return new DelegatingSecurityContextRepository(
//                new RequestAttributeSecurityContextRepository(),
//                new HttpSessionSecurityContextRepository()
//        );
//    }
}
