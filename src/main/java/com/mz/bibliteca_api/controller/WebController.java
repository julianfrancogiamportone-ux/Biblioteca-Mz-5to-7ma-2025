package com.mz.bibliteca_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WebController {
    @Autowired
    private org.springframework.core.io.ResourceLoader resourceLoader;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private class NotFoundException extends RuntimeException {}

    private boolean resourceExists(String location) {
        org.springframework.core.io.Resource resource = resourceLoader.getResource(location);
        try {
            return resource.exists() && resource.isReadable();
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/{urlHtml}.html")
    public String getUrlHtml(@PathVariable String urlHtml) {
        String templateLocation = "classpath:/templates/" + urlHtml + ".html";
        if (resourceExists(templateLocation)) {
            return urlHtml;
        }
        throw new NotFoundException();
    }

    @GetMapping("/{url}")
    public String getUrl(@PathVariable String url) {
        String templateLocation = "classpath:/templates/" + url + ".html";
        if (resourceExists(templateLocation)) {
            return url;
        }
        throw new NotFoundException();
    }
}
