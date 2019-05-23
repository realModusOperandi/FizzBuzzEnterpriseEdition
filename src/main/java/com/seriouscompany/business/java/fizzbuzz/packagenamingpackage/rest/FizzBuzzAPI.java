package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.rest;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.beans.FizzBuzzBean;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("fizzbuzz")
public class FizzBuzzAPI {
    @Inject
    private FizzBuzzBean fb;

    @GET
    @Produces("application/json")
    public String[] getFizzBuzz(@DefaultValue("100") @QueryParam("count") int count) {
        try {
            return fb.doFizzBuzz(count);
        } catch (Exception e) {
            throw new BadRequestException(e);
        }
    }
}
