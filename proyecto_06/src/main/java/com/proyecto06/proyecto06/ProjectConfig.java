
package com.proyecto06.proyecto06;


import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 *
 * @author TALLER
 */
@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localResolver() {
        var slr = new SessionLocaleResolver();

        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.timezone");

        return slr;

    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");

        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    /* Este método se utiliza al enviar correos de activación, según el idioma*/
    @Bean("messageSource")
    public MessageSource messageSource() {
       ResourceBundleMessageSource messageSource = 
               new ResourceBundleMessageSource();
       messageSource.setBasenames("messages");
       messageSource.setDefaultEncoding("UTF-8");
       return messageSource;
    }    
    
    
    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
 }

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/errores/**",
                        "/carrito/**","/pruebas/**","/reportes/**",
                        "/registro/**","/js/**","/webjars/**")
                        .permitAll()
                .requestMatchers(
                        "/paquetes/nuevo","/paquetes/guardar",
                        "/paquetes/modificar/**","/paquetes/eliminar/**",
                        "/categoria/nuevo","/categoria/guardar",
                        "/categoria/modificar/**","/categoria/eliminar/**",
                        "/reserva/nuevo","/reserva/guardar",
                        "/reserva/modificar/**","/reserva/eliminar/**",
                        "/checkin/nuevo","/checkin/guardar",
                        "/checkin/modificar/**","/checkin/eliminar/**",
                        "/pasajeros/nuevo","/pasajeros/guardar",
                        "/pasajeros/modificar/**","/pasajeros/eliminar/**",
                        "/contacto/nuevo","/contacto/guardar",
                        "/contacto/modificar/**","/contacto/eliminar/**",
                        "/pagos/nuevo","/pagos/guardar",
                        "/pagos/modificar/**","/pagos/eliminar/**",
                        "/vuelos/nuevo","/vuelos/guardar",
                        "/vuelos/modificar/**","/vuelos/eliminar/**",
                        "/usuario/nuevo","/usuario/guardar",
                        "/usuario/modificar/**","/usuario/eliminar/**",
                        "/reportes/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/paquetes/listado",
                        "/categoria/listado",
                        "/reserva/listado",
                        "/checkin/listado",
                        "/pasajeros/listado",
                        "/vuelos/listado",
                        "/contacto/listado",
                        "/pagos/listado",
                        "/usuario/listado"
                ).hasAnyRole("ADMIN","VENDEDOR")
                .requestMatchers("/facturar/carrito")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

/* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */    
//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder()
//                .username("juan")
//                .password("{noop}123")
//                .roles("USER", "VENDEDOR", "ADMIN")
//                .build();
//        UserDetails sales = User.builder()
//                .username("rebeca")
//                .password("{noop}456")
//                .roles("USER", "VENDEDOR")
//                .build();
//        UserDetails user = User.builder()
//                .username("pedro")
//                .password("{noop}789")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, sales, admin);
//    }

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Autowired
  public void configurerGlobal(
          AuthenticationManagerBuilder build)
          throws Exception {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
  
   /* El siguiente método se utilizar para publicar en la nube, independientemente  */
    @Bean
    public SpringResourceTemplateResolver templateResolver_0() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        return resolver;
    } 
    
}