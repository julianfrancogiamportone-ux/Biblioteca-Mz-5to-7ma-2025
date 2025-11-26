package com.mz.bibliteca_api.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class LoginController {
    
    @PostMapping("/login")
    @CrossOrigin(allowCredentials = "true", methods = {RequestMethod.POST, RequestMethod.GET}, originPatterns = {"http://127.0.0.1*", "https://127.0.0.1*", "http://localhost*", "https://localhost*", "http://127.0.0.1:3000*", "https://127.0.0.1:3000*", "http://localhost:3000*", "https://localhost:3000*"})
    public String login() {
        return "login";
    }
    

    @GetMapping("/api/usuarios/csrf")
    @CrossOrigin(allowCredentials = "false", origins = {"http://127.0.0.1", "https://127.0.0.1/", "http://localhost/", "https://localhost", "http://127.0.0.1:3000", "https://127.0.0.1:3000/", "http://localhost:3000/", "https://localhost:3000/"})
    public CsrfToken csrfToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
