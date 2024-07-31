package io.mend.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomInterceptor1 implements Interceptor {

    private static final Logger log = LogManager.getLogger(CustomInterceptor1.class);

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        log.info("CustomInterceptor1");

        ValueStack stack = invocation.getStack();
        String s = stack.findString("userName");

        if (!s.equalsIgnoreCase("nury") &&
                !s.equalsIgnoreCase("james") &&
                !s.equalsIgnoreCase("mary")) {
            throw new Exception("Invalid name detected in the Interceptor");
        } else {
            stack.set("userName", s.toUpperCase());
        }

        return invocation.invoke();
    }
}