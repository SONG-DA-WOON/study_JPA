package com.example.sssss.config.secure;

import com.example.sssss.entity.Study_member;
import com.example.sssss.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecureUser implements UserDetailsService {

    @Autowired
    StudyMemberService studyMemberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== SecureUser >> loadUserByUsername ====== ");

        Study_member studyMember = studyMemberService.doSelectLoginI(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + studyMember.getRole()));

        return new User(studyMember.getLoginId(), "{SHA-256}"+studyMember.getPassword(), authorities);
    }
}
