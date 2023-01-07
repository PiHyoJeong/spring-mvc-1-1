package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

   @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // http message body 가져오기
        System.out.println("messageBody = " + messageBody); //JSON 형태로 넣어서 출력해보기

       //helloData 로 변환하기 위해 jackson 라이브러리 사용하여 messageBody 를 HelloData로 변환
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

       String username = helloData.getUsername();
       int age = helloData.getAge();

       System.out.println("age = " + age);
       System.out.println("username = " + username);
   }
}


/*
@Override
protected void service(HelloData helloData) throws ServletException, IOException {
        helloData.getUsername();
        helloData.getAge();
        }*/