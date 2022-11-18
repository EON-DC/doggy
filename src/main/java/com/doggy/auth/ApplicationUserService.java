package com.doggy.auth;

import com.doggy.member.Member;
import com.doggy.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {


    private final MemberRepository memberRepository;

    public ApplicationUserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("ApplicationUserService.loadUserByUsername");
        System.out.println("username = " + username);
        Member findMember = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("id 를 찾을수 없음!"));

        ApplicationUser applicationUser = new ApplicationUser(
                findMember.getUsername(),
                findMember.getPassword(),
                findMember.getUserRole().getSimpleGrantedAuthorities(),
                true,
                true,
                true,
                true
        );
        return applicationUser;
    }

}
