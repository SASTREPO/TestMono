package io.mend.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class CustomInterceptor2 extends AbstractInterceptor {

    private static final Logger log = LogManager.getLogger(CustomInterceptor2.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        log.info("CustomInterceptor2");

        final ActionContext context = invocation.getInvocationContext();

        Map<String,Object> parameters1 = (Map<String, Object>) context.getContextMap().get("parameters");

        Map<String,Object> parameters2 = (Map<String,Object>)context.get(ActionContext.PARAMETERS);

        Map<String, String[]> parameters3 = context.getServletRequest().getParameterMap();

        String parameter1 = context.getServletRequest().getParameter("user.name");

        String parameter2 = invocation.getStack().findString("userName");

        Map<String,Object> sessions1 = (Map<String,Object>)context.get(ActionContext.SESSION);

        Map<String,Object> sessions2 = context.getSession();

        return invocation.invoke();
    }
}
