package at.htl.carshop.model;

import at.htl.carshop.DTO.CarDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/car")
@Consumes(MediaType.APPLICATION_JSON)
public interface CarClient {
    @GET
    Car[] all();

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") Long id);
    @POST
    void add(CarDTO car);
}
