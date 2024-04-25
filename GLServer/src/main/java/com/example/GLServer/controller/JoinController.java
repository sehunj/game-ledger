package com.example.GLServer.controller;

import com.example.GLServer.dto.JoinInfoDTO;
import com.example.GLServer.dto.UsernamePasswordDTO;
import com.example.GLServer.service.JoinService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService){
        this.joinService = joinService;
    }

    @PostMapping("/signup/auth")
    public String joinAuthProcess(@RequestParam("emailPhone") String emailPhone, @RequestParam("type") Boolean type) throws UnsupportedEncodingException {
        return joinService.joinAuth(emailPhone, type);
    }

    @PostMapping("/signup/auth/check")
    public String joinAuthCheckProcess(@RequestParam("authCode") String authCode){
        joinService.joinAuthCheck(authCode);
        return "ok";
    }

    @PostMapping("/signup/user")
    public String joinUserProcess(UsernamePasswordDTO usernamePasswordDTO){
        return joinService.joinUser(usernamePasswordDTO);
    }

    @PostMapping("/signup/input")
    public String joinInputProcess(JoinInfoDTO joinInfoDto){
        return joinService.joinInput(joinInfoDto);
    }

}
