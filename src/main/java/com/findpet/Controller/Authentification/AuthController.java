package com.findpet.Controller.Authentification;


import com.findpet.Dto.UserDto;
import com.findpet.Entity.User;
import com.findpet.Request.AuthenticationRequest;
import com.findpet.Services.UserService;
import com.findpet.helpers.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println("---auth controller---");
        System.out.println("apller AuthenticationManager :");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        System.out.println("back to auth controller");
        User user = userService.findUserByEmail(authenticationRequest.getEmail());
        Map<String, Object> authResponse = new HashMap<>();
        if (user != null) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("Normal_User")));
            System.out.println(userDetails);

            authResponse.put("token",jwtUtils.generateToken(userDetails));
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            authResponse.put("userInfo", userDto);
            return ResponseEntity.ok(authResponse);
        }

        authResponse.put("token", null);
        authResponse.put("userInfo", null);
        return ResponseEntity.status(400).body(authResponse);
    }
}
