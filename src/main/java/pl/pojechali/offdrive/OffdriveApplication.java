package pl.pojechali.offdrive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class OffdriveApplication {

  public static void main(String[] args) {
    SpringApplication.run(OffdriveApplication.class, args);
  }

  @Autowired(required = false)
  private JavaMailSender mailSender;

  @Bean
  public CommandLineRunner springMail() {
    return args -> {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Create Account"); // tu wpisac tekst
        message.setFrom("offdrive@gmail.com");
        message.setText("Please use this link to authorise account in OffDrive");
        mailSender.send(message);
    };
  }

}
