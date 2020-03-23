package com.peepalsoft.app.controller;

import com.peepalsoft.app.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    MemberRepo memberRepo;
    @Autowired
    public MemberController(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;  }







}
