package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.RetrieveGeographicLocation;
import io.swagger.model.RetrieveGeographicLocationCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Controller
public class RetrieveGeographicLocationApiController implements RetrieveGeographicLocationApi {

    private static final Logger log = LoggerFactory.getLogger(RetrieveGeographicLocationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private BaseServiceImpl<RetrieveGeographicLocation> retrieveGeographicLocationBaseService;

    @org.springframework.beans.factory.annotation.Autowired
    public RetrieveGeographicLocationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<RetrieveGeographicLocation> createRetrieveGeographicLocation(@ApiParam(value = "The Retrieve Geographic Location to be created" ,required=true )  @Valid @RequestBody RetrieveGeographicLocationCreate retrieveGeographicLocation) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RetrieveGeographicLocation>(objectMapper.readValue("{  \"geographicLocation\" : {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  },  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"thing\" : {    \"type\" : \"type\",    \"uri\" : \"uri\"  },  \"status\" : \"status\",  \"requestedAccuracy\" : 0.8008282}", RetrieveGeographicLocation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RetrieveGeographicLocation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RetrieveGeographicLocation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RetrieveGeographicLocation>> listRetrieveGeographicLocation(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "For filtering: A string. Status of the task (inProgress, terminatedWithErrror, done).") @Valid @RequestParam(value = "status", required = false) String status,@ApiParam(value = "For filtering: Requested accuracy of the retrieval") @Valid @RequestParam(value = "requestedAccuracy", required = false) Float requestedAccuracy,@ApiParam(value = "For filtering: Timestamp of end of task execution") @Valid @RequestParam(value = "time", required = false) OffsetDateTime time,@ApiParam(value = "For filtering: A string. Name of the geo location.") @Valid @RequestParam(value = "geographicLocation.name", required = false) String geographicLocationName,@ApiParam(value = "For filtering: A string. Type of the geographic location - one of: point, line, graph, ring polygon") @Valid @RequestParam(value = "geographicLocation.type", required = false) String geographicLocationType,@ApiParam(value = "For filtering: ") @Valid @RequestParam(value = "thing.type", required = false) String thingType,@ApiParam(value = "For filtering: ") @Valid @RequestParam(value = "thing.uri", required = false) String thingUri) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
             //  return new ResponseEntity<List<RetrieveGeographicLocation>>(objectMapper.readValue("[ {  \"geographicLocation\" : {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  },  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"thing\" : {    \"type\" : \"type\",    \"uri\" : \"uri\"  },  \"status\" : \"status\",  \"requestedAccuracy\" : 0.8008282}, {  \"geographicLocation\" : {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  },  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"thing\" : {    \"type\" : \"type\",    \"uri\" : \"uri\"  },  \"status\" : \"status\",  \"requestedAccuracy\" : 0.8008282} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                return new ResponseEntity<List<RetrieveGeographicLocation>>(
                        retrieveGeographicLocationBaseService.list(),
                        HttpStatus.OK
                );
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<RetrieveGeographicLocation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<RetrieveGeographicLocation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RetrieveGeographicLocation>> retrieveRetrieveGeographicLocation(@ApiParam(value = "Identifier of the Retrieve Geographic Location",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<RetrieveGeographicLocation>>(objectMapper.readValue("[ {  \"geographicLocation\" : {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  },  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"thing\" : {    \"type\" : \"type\",    \"uri\" : \"uri\"  },  \"status\" : \"status\",  \"requestedAccuracy\" : 0.8008282}, {  \"geographicLocation\" : {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  },  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"thing\" : {    \"type\" : \"type\",    \"uri\" : \"uri\"  },  \"status\" : \"status\",  \"requestedAccuracy\" : 0.8008282} ]", List.class), HttpStatus.NOT_IMPLEMENTED);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<RetrieveGeographicLocation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<RetrieveGeographicLocation>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
