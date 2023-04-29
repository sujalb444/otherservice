package com.mopa.pacc.pmis.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

        @Service
        @Transactional
        public class UserDetailsServiceImpl implements UserDetailsService {
            @Autowired
            private UserRepository userRepository;
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
                return UserMapper.userToPrincipal(user);
            }
        }
    


