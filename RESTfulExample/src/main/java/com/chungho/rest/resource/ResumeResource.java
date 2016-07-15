package com.chungho.rest.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import com.chungho.rest.model.Resume;
import com.chungho.rest.dao.ResumeDao;
//import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import javax.xml.bind.JAXBException;

@Path("/")
public class ResumeResource {

    //Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getResume/{id}")
    public Resume getResumebyId(@PathParam("id") String id) {

        Resume resume = ResumeDao.instance.getModelbyId(id);
        return resume;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/uploadResumeDetails")
    public int setResume(String jsonRequest) throws JAXBException {

        System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

        System.out.print(jsonRequest);
        Resume r = deserialize(jsonRequest);

        return ResumeDao.instance.setModel(r);
    }

    public Resume deserialize(String inputStream) throws JAXBException{
            // Create a JaxBContext
            JAXBContext jc = JAXBContext.newInstance(Resume.class);

            // Create the Unmarshaller Object using the JaxB Context
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            // Set the Unmarshaller media type to JSON
            unmarshaller.setProperty("eclipselink.media-type", "application/json");
            unmarshaller.setProperty("eclipselink.json.include-root", false);

            // Create the StreamSource by creating StringReader using the JSON input
            StreamSource json = new StreamSource(new StringReader(inputStream));

            // Getting the Resume pojo again from the json
            Resume resume = unmarshaller.unmarshal(json, Resume.class).getValue();
            return resume;

    }

}
