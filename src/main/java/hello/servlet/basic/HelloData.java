package hello.servlet.basic;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class HelloData {
    private String username;
    private int age;
}
