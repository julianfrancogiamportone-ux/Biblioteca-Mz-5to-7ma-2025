package com.mz.bibliteca_api.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @GetMapping("/api/usuarios/csfr")
    public CsrfToken csrfToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
