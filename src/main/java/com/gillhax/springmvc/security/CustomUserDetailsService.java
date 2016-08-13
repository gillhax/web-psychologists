package com.gillhax.springmvc.security;

/**
 * Created by alex on 04.08.2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.gillhax.springmvc.model.Psychologist;
import com.gillhax.springmvc.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private PsychologistService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Psychologist user = userService.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
               true, true, true, true, getGrantedAuthorities());
    }


    private List<GrantedAuthority> getGrantedAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

}