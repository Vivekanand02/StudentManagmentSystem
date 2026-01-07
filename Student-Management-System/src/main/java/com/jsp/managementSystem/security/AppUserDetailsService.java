package com.jsp.managementSystem.security;

import com.jsp.managementSystem.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return studentRepository.findByMail(mail).orElseThrow(()->  new UsernameNotFoundException("User not found"));
    }
}
