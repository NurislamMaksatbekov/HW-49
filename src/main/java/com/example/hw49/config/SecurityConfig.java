//package com.example.hw49.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//    private static final String FETCH_USERS_QUERY = "select email, password, enabled \n" +
//            "from users \n" +
//            "where email = ?;";
//
//    private static final String FETCH_ROLES_QUERY = "select email, account_type \n" +
//            "from users \n" +
//            "where email = ?;";
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    private final DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(FETCH_USERS_QUERY)
//                .authoritiesByUsernameQuery(FETCH_ROLES_QUERY);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/employer/vacancy/**")).hasAuthority("EMPLOYER")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/employer/newVacancy**")).hasAuthority("EMPLOYER")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/employer/resume/title/**")).hasAuthority("EMPLOYER")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/employer/applicant/**")).hasAuthority("EMPLOYER")
//
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/applicant/resume/**")).hasAuthority("APPLICANT")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/applicant/newResume/**")).hasAuthority("APPLICANT")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/applicant/vacancyCategory/**")).hasAuthority("APPLICANT")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/applicant/employer/email/**")).hasAuthority("APPLICANT")
//
//
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }
//}
