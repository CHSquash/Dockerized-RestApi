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
import com.fasterxml.jackson.databind.ObjectMapper;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/uploadResumeDetails")
    public String setResume(JAXBElement<Resume> resume) {

        return "ss";
    }


}