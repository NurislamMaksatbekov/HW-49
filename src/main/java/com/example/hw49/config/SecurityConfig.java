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
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/vacancy**")).hasAuthority("Employer")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/newVacancy**")).hasAuthority("Employer")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/resume/title/**")).hasAuthority("Employer")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/applicant/id/**")).hasAuthority("Employer")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/applicant/email/**")).hasAuthority("Employer")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/vacancies/vacancy/id/**")).hasAuthority("Employer")
//
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/resume/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/newResume/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/vacancyCategory/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/resume/id/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/resume/email/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/employer/email/**")).hasAuthority("Applicant")
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/resumes/resume/**")).hasAuthority("Applicant")
//
//
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }
//}
