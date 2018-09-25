package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.servlet;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.FizzBuzz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/")
public class FizzBuzzServlet extends javax.servlet.http.HttpServlet {
    private PrintStream out;
    private FizzBuzz fb;

    public void setUp() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        this.fb = (FizzBuzz) context.getBean("standardFizzBuzz");
        this.out = System.out;
        ((ConfigurableApplicationContext) context).close();
    }

    public void tearDown() {
        System.setOut(this.out);
    }

    private void doFizzBuzz(final int n) throws IOException {

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.setUp();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final BufferedOutputStream bos = new BufferedOutputStream(baos);
        System.setOut(new PrintStream(bos));

        this.fb.fizzBuzz(100);

        System.out.flush();
        this.tearDown();

        BufferedWriter writer = new BufferedWriter(response.getWriter());
        writer.write(baos.toString());
        writer.close();

    }
}
