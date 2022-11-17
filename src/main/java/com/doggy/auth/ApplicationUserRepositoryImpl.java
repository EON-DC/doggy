package com.doggy.auth;


import com.doggy.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("auth")
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private final ApplicationUserRepository applicationUserRepository;
    // memberRepository 에서 가져옴
    private final MemberService memberService;


    @Autowired
    public ApplicationUserRepositoryImpl(ApplicationUserRepository applicationUserRepository,
                                         MemberService memberService) {
        this.applicationUserRepository = applicationUserRepository;
        this.memberService = memberService;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return memberService.getApplicationUsers().stream()
                .filter(applicationUser -> applicationUser.getUsername().equals(username))
                .findFirst();
    }


}
