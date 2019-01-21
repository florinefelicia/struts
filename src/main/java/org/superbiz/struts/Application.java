package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import org.apache.struts2.dispatcher.FilterDispatcher;
import org.apache.struts2.dispatcher.ActionContextCleanUp;

import javax.servlet.Filter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @Bean
//    public Filter filterDispatcher(){
//        FilterDispatcher filterDispatcher = new FilterDispatcher();
//        return filterDispatcher;
//    }
//    @Bean
//    public Filter actionContextCleanUp(){
//        ActionContextCleanUp actionContextCleanUp = new ActionContextCleanUp();
//        return actionContextCleanUp;
//    }
//    @Bean
//    public Filter pageFilter(){
//        PageFilter pageFilter = new PageFilter();
//        return pageFilter;
//    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterDispatcher filterDispatcher = new FilterDispatcher();
        ActionContextCleanUp actionContextCleanUp = new ActionContextCleanUp();
        PageFilter pageFilter = new PageFilter();

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filterDispatcher);
        filterRegistrationBean.setFilter(actionContextCleanUp);
        filterRegistrationBean.setFilter(pageFilter);

        return filterRegistrationBean;
    }
}
