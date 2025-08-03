package org.springframework.mvc.javaannotationbased.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        //con
        return new Class[]{DispatcherServletContextConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //url mapping
        return new String[]{"/"};
    }
}
