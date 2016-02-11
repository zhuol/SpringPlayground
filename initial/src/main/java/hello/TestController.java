package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Test, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Test test(@RequestParam(value="name", defaultValue="Controller") String name) {
        return new Test(counter.incrementAndGet(),
                String.format(template, name));
    }
}