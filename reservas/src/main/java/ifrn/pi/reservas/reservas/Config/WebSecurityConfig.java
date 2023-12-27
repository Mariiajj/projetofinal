package ifrn.pi.reservas.reservas.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebSecurityConfig {
	

    @Autowired
    private AlunoUserDetailsService al;

    @Autowired
    private MotoristaUserDetailsService mt;

     @Autowired
    private AdminUserDetailsService ad;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                 .requestMatchers("/admin").permitAll()
                .requestMatchers("/alunos/formA").permitAll()
                .requestMatchers("/motoristas/formM").permitAll()
                .requestMatchers(HttpMethod.POST,"/admin/cadastro").permitAll()
				.requestMatchers(HttpMethod.POST,"/alunos/cadastro").permitAll()
                .requestMatchers(HttpMethod.POST,"/motoristas/cadastro").permitAll()
                .requestMatchers("/menu/**").permitAll()
				.anyRequest().authenticated()
			)
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/onibus/home")
                .permitAll()
                .and()
            .logout()
            .logoutRequestMatcher(
                new AntPathRequestMatcher("/logout", "GET")
            )
            .logoutSuccessUrl("/login");
		return http.build();
	}
	
	

    
    @Autowired
    public void configureBlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth .userDetailsService(mt).passwordEncoder(new BCryptPasswordEncoder());
       auth. userDetailsService(al).passwordEncoder(new BCryptPasswordEncoder());
       auth. userDetailsService(ad).passwordEncoder(new BCryptPasswordEncoder());
       
        
    } 
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
