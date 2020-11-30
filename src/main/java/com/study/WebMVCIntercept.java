package com.study;

import com.study.handler.LogIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCIntercept implements WebMvcConfigurer {
  @Autowired private LogIntercept logIntercept;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logIntercept).addPathPatterns("/**").excludePathPatterns("/js", "/css");
  }
}
