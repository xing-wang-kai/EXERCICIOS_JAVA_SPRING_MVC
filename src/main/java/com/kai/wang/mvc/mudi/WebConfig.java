package com.kai.wang.mvc.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.kai.wang.mvc.mudi.interceptor.InterceptorParaAcesso;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptorParaAcesso()).addPathPatterns("/**");
	}
}
