package com.me.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zhaohaojie
 * @date 2019-02-04 15:38
 */
@WebServlet(urlPatterns = "/servlet.test",asyncSupported = true)
public class TestServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String strline = "100";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet method is invoked.");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("dopost method is invoked.");
        Reader reader = new InputStreamReader(req.getInputStream());
        char[] rs = new char[1024];
        while (reader.read(rs) > 0) {
            System.out.println(rs);
        }
        OutputStream out = resp.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.write(strline+Thread.currentThread().getName());
        writer.flush();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}

