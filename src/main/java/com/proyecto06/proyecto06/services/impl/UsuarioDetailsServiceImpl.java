
package com.proyecto06.proyecto06.services.impl;


import com.proyecto06.proyecto06.dao.UsuarioDao;
import com.proyecto06.proyecto06.domain.Rol;
import com.proyecto06.proyecto06.domain.Usuario;
import com.proyecto06.proyecto06.services.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
        implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        
        
        //se busca el registro en la tabla de usuarios mediante el findByUSername
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //se valida si se recuopero un usuario de la tabla
        if (usuario==null){
            //no se encontro
            throw new UsernameNotFoundException(username);
        }
        
        //si estamos aca... Si se encontro el usuario
        
        //Aca va la recuperacion de la foto..
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Se recupera los roles
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol r: usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        
        //se devuelve un usuario ya de tipo UserDetails
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
 
}
