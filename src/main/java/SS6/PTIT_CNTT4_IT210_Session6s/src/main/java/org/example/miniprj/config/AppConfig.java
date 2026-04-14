package org.example.miniprj.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.miniprj")
public class AppConfig {
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        // set tiền tố
        resolver.setPrefix("/WEB-INF/views/");
        // set hậu tố
        resolver.setSuffix(".html");

        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 2. Bean SpringTemplateEngine - bộ máy trung tâm xử lý và chuyển các cú pháp thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        // Để sử dụng được layout dialect của thymeleaf phải thêm vào
//        engine.setDialect(new LayoutDialect());

        return engine;
    }

    // 3. Bean ThymeleafViewResolver - giao tiếp Spring MVC với Thymeleaf
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
