package com.services.cxf.soap.client;

import com.services.cxf.soap.generated.wsdl.services.person.PersonPortType;
import com.services.cxf.soap.generated.wsdl.services.person.ServiceFaultException;
import com.services.cxf.soap.generated.wsdl.types.person.ObjectFactory;
import com.services.cxf.soap.generated.wsdl.types.person.Person;
import com.services.cxf.soap.generated.wsdl.types.person.Request;
import com.services.cxf.soap.generated.wsdl.types.person.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonClient {

    @Autowired
    private PersonPortType ClientProxyBean;

    public List<Person> getFriends(Person person, int year) throws ServiceFaultException {

        ObjectFactory factory = new ObjectFactory();
        Request request = factory.createRequest();

        request.setPerson(person);
        request.setYear(year);

        Response response = ClientProxyBean.getFriends(request);

        return response.getFriends();
    }
}
