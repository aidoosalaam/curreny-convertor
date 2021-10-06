package com.charmedteeth.currencyrate.controller;

import com.charmedteeth.currencyrate.model.JwtRequest;
import com.charmedteeth.currencyrate.model.JwtResponse;
import com.charmedteeth.currencyrate.services.JwtTokenUtil;
import com.charmedteeth.currencyrate.services.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/convert/currency")
public class JwtAuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception{
        authenticate(authRequest.getClientId(), authRequest.getClientKey());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getClientId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void  authenticate(String username , String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw  new Exception("User Disabled : ", e);
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid Credentials : ", e);
        }
    }
}
