package learn.springboot.bai8_ThuHanh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class UserConfigutation {


    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource datasource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(datasource);

        return userDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        // Tao ra tam 1 vai nguoi dung
//        UserDetails tung = User.withUsername("tung")
//                .password("{noop}123456")
//                .roles("teacher")
//                .build();
//
//        UserDetails quoc = User.withUsername("quoc")
//                .password("{noop}123456")
//                .roles("manager")
//                .build();
//
//        UserDetails kiet = User.withUsername("kiet")
//                .password("{noop}123456")
//                .roles("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(tung, quoc, kiet);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurar -> configurar
                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasAnyRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());
        // csrf -> cross site request forgery (tim hieu no)

        return http.build();
    }
}
