package com.kbds.kbforum.core.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.ISpringTemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * <pre>
 * 파일명     : ThymeleafViewResolverConfig.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	      유한솔                     	|   타임리프를 사용하기위한 설정          |	
 * ===============================================================================
 * </pre>
 */

@Configuration
@EnableWebMvc
public class ThymeleafViewResolverConfig {

  @Autowired
  private ApplicationContext applicationContext;

  private ITemplateResolver templateResolver() {

    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

    resolver.setApplicationContext(applicationContext);

    resolver.setPrefix("/WEB-INF/templates/");

    resolver.setSuffix(".html");

    resolver.setCharacterEncoding("UTF-8");

    resolver.setTemplateMode(TemplateMode.HTML);

    resolver.setCacheable(false);

    return resolver;

  }

  @Bean

  public ViewResolver viewResolver() {

    ThymeleafViewResolver resolver = new ThymeleafViewResolver();

    resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());

    resolver.setCharacterEncoding("UTF-8");

    return resolver;

  }

  @Bean

  public TemplateEngine templateEngine() {

    SpringTemplateEngine engine = new SpringTemplateEngine();

    engine.setEnableSpringELCompiler(true);

    engine.setTemplateResolver(templateResolver());

    return engine;

  }

}
