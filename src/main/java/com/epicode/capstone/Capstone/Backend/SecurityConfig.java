package com.epicode.capstone.Capstone.Backend;//package com.epicode.capstone.Capstone.Backend;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class SecurityConfig {
//
//    @EnableWebSecurity
//    @Configuration
//    static class OktaOAuth2WebSecurityConfiguration {
//
//        @Bean
//        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            return http.authorizeHttpRequests(
//                            (req) -> req.requestMatchers("/api/whoami").authenticated()
//                                    .requestMatchers("/**").permitAll()
//                    )
//                    .oauth2ResourceServer((srv) -> srv.jwt(Customizer.withDefaults()))
//                    .build();
//        }
//    }
//}

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/orders/**")
                                .authenticated()
//                                .requestMatchers(HttpMethod.POST, "/products")
//                                .authenticated()

                                .anyRequest().permitAll())
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));

        //        http.cors(Customizer.withDefaults());
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
        Okta.configureResourceServer401ResponseBody(http);
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}