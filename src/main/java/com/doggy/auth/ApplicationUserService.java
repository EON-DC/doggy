package com.doggy.auth;

import com.doggy.domain.Member;
import com.doggy.domain.MemberRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.MemberRemoval;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot fount username: " + username));
        ApplicationUser loginUser = new ApplicationUser(member);
        return loginUser;
    }
}
