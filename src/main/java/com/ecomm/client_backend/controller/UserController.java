package com.ecomm.client_backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/ip")
    public ResponseEntity<String> getInfo() {
        log.info("Get info triggered!!");
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            return ResponseEntity.ok(ipAddress);
        } catch (UnknownHostException e) {
            return ResponseEntity.status(500).body("Unable to fetch IP address");
        }
    }
}
