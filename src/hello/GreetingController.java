package hello;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/region/greeting")
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, new Region().getContent()));
    }

    @RequestMapping("/region/{region}/greeting")
    public Greeting greeting(@PathVariable("region") String region, HttpServletRequest request) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, region));
    }    
}