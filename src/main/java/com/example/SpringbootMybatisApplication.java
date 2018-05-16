package com.example;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.example.mapper")
@EnableSwagger2
@Controller
public class SpringbootMybatisApplication {

    public static void main(String[] args) {

       /* try {
            FileOutputStream out = new FileOutputStream("F:/test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

    //Tomcat large file upload connection reset
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    @GetMapping("/eInfo")
    public String eInfo() {
        return "eInfo";
    }
    @GetMapping("/tInfo")
    public String tInfo() {
        return "tInfo";
    }

    @GetMapping("/loan")
    public String loan() {
        return "loan";
    }

    @GetMapping("/circulateInfo")
    public String circulateInfo() {
        return "circulateInfo";
    }

    @GetMapping("/scrapInfo")
    public String scrapInfo() {
        return "scrapInfo";
    }

    @GetMapping("/repairInfo")
    public String repairInfo() {
        return "repairInfo";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
