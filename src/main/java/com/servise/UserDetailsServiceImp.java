package com.servise;

import com.repository.UserRepository;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("UserDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.entity.User user = null;
        user = userRepository.findOneByUserName(login);
        if (user == null){
            user = userRepository.findOneByEMail(login);
        }
        if (user == null){
            return null;
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(String.valueOf(user.getId()), user.getPassword(),authorities);//user.getIsEnabled(), true, true, true
    }

}
