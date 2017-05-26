package com.services.cxf.soap.client;

import com.services.cxf.soap.generated.wsdl.services.person.PersonPortType;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Value("http://localhost:8181/cxf/person")
    private String serviceAddress;

    @Bean(name = "ClientProxyBean")
    public PersonPortType opportunityPortType() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(PersonPortType.class);
        jaxWsProxyFactoryBean.setAddress(serviceAddress);
        return (PersonPortType) jaxWsProxyFactoryBean.create();
    }
}
