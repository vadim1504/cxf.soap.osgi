package com.services.cxf.soap.endpoint;

import com.services.cxf.soap.generated.wsdl.services.person.PersonPortType;
import com.services.cxf.soap.generated.wsdl.services.person.ServiceFaultException;
import com.services.cxf.soap.generated.wsdl.types.person.ObjectFactory;
import com.services.cxf.soap.generated.wsdl.types.person.Person;
import com.services.cxf.soap.generated.wsdl.types.person.Request;
import com.services.cxf.soap.generated.wsdl.types.person.Response;
import com.services.cxf.soap.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class PersonImpl implements PersonPortType {

    @Autowired
    private PersonService personService;

    @Override
    public Response getFriends(Request request) throws ServiceFaultException {
        List<Person> personList = personService.getFriends(request.getPerson(),request.getYear());
        ObjectFactory objectFactory = new ObjectFactory();
        Response response = objectFactory.createResponse();
        response.getFriends().addAll(personList);
        return response;
    }
}