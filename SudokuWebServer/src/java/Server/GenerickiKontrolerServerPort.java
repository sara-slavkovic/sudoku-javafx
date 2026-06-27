/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Server;

import Server_client.GenerickiKontrolerServer;
import Server_client.Korisnik;
import Server_client.VratiRangListuResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Korisnik
 */
@Path("generickikontrolerserverport")
public class GenerickiKontrolerServerPort {

    private GenerickiKontrolerServer port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerickiKontrolerServerPort
     */
    public GenerickiKontrolerServerPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method registrujKorisnika
     * @param arg0 resource URI parameter
     * @return an instance of java.lang.String
     */
    @POST
    @Produces("text/plain")
    @Consumes("application/xml")
    @Path("registrujkorisnika/")
    public String postRegistrujKorisnika(JAXBElement<Korisnik> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.registrujKorisnika(arg0.getValue());
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method vratiRangListu
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.VratiRangListuResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("vratiranglistu/")
    public JAXBElement<VratiRangListuResponse> getVratiRangListu(@QueryParam("arg0")
            @DefaultValue("0") int arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<Server_client.Igra> result = port.vratiRangListu(arg0);

                class VratiRangListuResponse_1 extends Server_client.VratiRangListuResponse {

                    VratiRangListuResponse_1(java.util.List<Server_client.Igra> _return) {
                        this._return = _return;
                    }
                }
                Server_client.VratiRangListuResponse response = new VratiRangListuResponse_1(result);
                return new Server_client.ObjectFactory().createVratiRangListuResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private GenerickiKontrolerServer getPort() {
        try {
            // Call Web Service Operation
            Server_client.GenerickiKontrolerServer_Service service = new Server_client.GenerickiKontrolerServer_Service();
            Server_client.GenerickiKontrolerServer p = service.getGenerickiKontrolerServerPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
