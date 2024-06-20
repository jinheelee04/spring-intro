package hello.core.spring.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Scope(value = "request")
 * - HTTP 요청 당 하나씩 생성되고, HTTP요청이 끝나는 시점에 소멸된다.
 */
@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "["+ requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:"+ this);

    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close:"+ this);
    }
}
