package com.codetest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;
import com.codetest.rest.AuthRest;
import com.codetest.rest.StudentSubjectRest;
 
@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
        register(StudentSubjectRest.class);
        register(AuthRest.class);
        packages("...");
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
   
}
