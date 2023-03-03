package com.example.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        LocalDateTime servletTimeInit = LocalDateTime.now();
        sre.getServletContext().setAttribute("servletTimeInit", servletTimeInit);
    }
}
