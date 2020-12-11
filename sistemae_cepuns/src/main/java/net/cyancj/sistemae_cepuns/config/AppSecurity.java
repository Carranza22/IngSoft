package net.cyancj.sistemae_cepuns.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class AppSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery(
                        "select usuario as username, clave as password, estado as enabled "
                                + "from Usuario as users where usuario = ?")
                .authoritiesByUsernameQuery(
                        "select usuario as username, rol as authority "
                                + "from Usuario as authorities where usuario = ?");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/administrador/").hasAnyAuthority("ADMINISTRADOR","MATRICULA","ASISTENCIA","NOTAS")
                .antMatchers("/matricula/**").hasAnyAuthority("MATRICULA","ADMINISTRADOR")
                .antMatchers("/alumno/**").hasAnyAuthority("MATRICULA","ADMINISTRADOR")
                .antMatchers("/notas/**").hasAnyAuthority("NOTAS","ADMINISTRADOR")
                .antMatchers("/asistencia/**").hasAnyAuthority("ASISTENCIA","ADMINISTRADOR")
                .and()
                .formLogin().loginPage("/")
                .defaultSuccessUrl("/success")
                .failureUrl("/?error")
                .usernameParameter("usuario").passwordParameter("contrasena")
                .and()
                .logout().logoutSuccessUrl("/?logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
