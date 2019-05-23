package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.beans;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.FizzBuzz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.BeforeDestroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.io.*;

@ApplicationScoped
public class FizzBuzzBean {
    private PrintStream out;
    private FizzBuzz fb;

    @PostConstruct
    public void postConstruct() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        this.fb = (FizzBuzz) context.getBean("standardFizzBuzz");
        this.out = System.out;
        ((ConfigurableApplicationContext) context).close();
    }

    public String[] doFizzBuzz(int count) throws Exception {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final BufferedOutputStream bos = new BufferedOutputStream(baos);
        System.setOut(new PrintStream(bos));

        this.fb.fizzBuzz(count);

        System.out.flush();

        StringWriter writer = new StringWriter();
        writer.write(baos.toString());
        writer.close();

        return writer.toString().split("\n");
    }

    @PreDestroy
    public void preDestroy() {
        System.setOut(this.out);
    }
}
