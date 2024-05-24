package at.htl.carshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import at.htl.carshop.DTO.RepairDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/repair")
@Consumes(MediaType.APPLICATION_JSON)
public interface RepairClient {
    @GET
    Repair[] all();

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") Long id);

    @POST
    void add(RepairDTO repair);
}
