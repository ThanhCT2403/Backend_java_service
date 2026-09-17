package vn.demo.backend_java_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.demo.backend_java_service.service.EmailService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "EMAIL-CONTROLLER")
public class EmailController {
    private final EmailService emailService;

    @GetMapping("/send-email")
    public void sendEmail(@RequestParam String to, String subject, String body) {
        log.info("Sending email to {}", to);
        emailService.send(to, subject, body);
        log.info("Email send");
    }

    @GetMapping("/verify-email")
    public void emailVerification(@RequestParam String to, String name) throws IOException {
        log.info("Verifying email to {}", to);
        emailService.emailVerification(to, name);
    }
}
