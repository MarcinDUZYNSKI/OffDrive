package pl.pojechali.offdrive;

import com.sun.tools.javac.util.List;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

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

      FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
      freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/mail/templates");
      Configuration configuration = freeMarkerConfigurer.createConfiguration();

      Template mailTemplate = configuration.getTemplate("test-mail.html");
      Map<String, Object> model = new HashMap<>();
      model.put("username", "joeSmith");
      model.put("today", LocalDate.now());
      model.put("orders", List.of("Lala", "Piłka"));


      String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, null);
      message.setText(mailBody);

      MimeMessage mimeMessage = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
      mailSender.send(message);
    };

  }

}
