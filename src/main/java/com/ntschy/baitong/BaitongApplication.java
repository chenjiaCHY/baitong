package com.ntschy.baitong;

import com.ntschy.baitong.datasource.aop.DynamicDataSourceAnnotationAdvisor;
import com.ntschy.baitong.datasource.aop.DynamicDataSourceAnnotationInterceptor;
import com.ntschy.baitong.datasource.dynamic.DynamicDatasourceRegister;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@Import(DynamicDatasourceRegister.class)
@SpringBootApplication
@EnableTransactionManagement
public class BaitongApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaitongApplication.class, args);
	}

	@Bean
	public DynamicDataSourceAnnotationAdvisor dynamicDataSourceAnnotationAdvisor() {
		return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
	}
}
