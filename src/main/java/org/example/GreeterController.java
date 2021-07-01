package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    private static Logger logger = LoggerFactory.getLogger(GreeterController.class);

    @Value("${greeter.message}")
    private String greeterMessageFormat;
    //http://localhost:22222/greet/harsha
    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        logger.info("Prefix :{} and User:{}", prefix, user);
        if (prefix == null) {
            prefix = "Hello!";
        }
        return String.format(greeterMessageFormat, prefix, user);
    }
}
