package com.design.test;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MultipleReadHttpServletRequest extends HttpServletRequestWrapper {
    public String requestBody;
    public MultipleReadHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                requestBody.getBytes());
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }
}
