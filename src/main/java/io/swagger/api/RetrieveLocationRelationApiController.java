package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.service.RetrieveLocationRelationServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.RetrieveLocationRelation;
import io.swagger.model.RetrieveLocationRelationCreate;
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
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Controller
public class RetrieveLocationRelationApiController implements RetrieveLocationRelationApi {

    private static final Logger log = LoggerFactory.getLogger(RetrieveLocationRelationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private RetrieveLocationRelationServiceImpl<RetrieveLocationRelation> serviceRLR;

    @org.springframework.beans.factory.annotation.Autowired
    public RetrieveLocationRelationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<RetrieveLocationRelation> createRetrieveLocationRelation
        (
                @ApiParam(value = "The Retrieve Location Relation to be created" ,required=true )
                @Valid @RequestBody RetrieveLocationRelationCreate retrieveLocationRelation
        ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
               RetrieveLocationRelation createRLR = new RetrieveLocationRelation();
                BeanUtils.copyProperties(retrieveLocationRelation,createRLR);
                serviceRLR.save(createRLR);
               return new ResponseEntity<RetrieveLocationRelation>(createRLR,HttpStatus.OK);
                // return new ResponseEntity<RetrieveLocationRelation>(objectMapper.readValue("{  \"distance\" : \"distance\",  \"geographicLocation\" : {    \"id\" : \"id\",    \"href\" : \"href\"  },  \"intersection\" : [ {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  }, {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  } ],  \"locationA\" : \"locationA\",  \"locationB\" : \"locationB\",  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"status\" : \"status\"}", RetrieveLocationRelation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RetrieveLocationRelation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RetrieveLocationRelation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RetrieveLocationRelation>> listRetrieveLocationRelation
        (
                @ApiParam(value = "Comma separated properties to display in response")
                @Valid @RequestParam(value = "fields", required = false) String fields,
                @ApiParam(value = "For filtering: A string. Status of the task (inProgress, terminatedWithErrror, done).")
                @Valid @RequestParam(value = "status", required = false) String status,
                @ApiParam(value = "For filtering: Reference to a location")
                @Valid @RequestParam(value = "locationA", required = false) String locationA,
                @ApiParam(value = "For filtering: Reference to a location")
                @Valid @RequestParam(value = "locationB", required = false) String locationB,
                @ApiParam(value = "For filtering: Calculated distance between location A and location B")
                @Valid @RequestParam(value = "distance", required = false) String distance,
                @ApiParam(value = "For filtering: Timestamp of end of task execution")
                @Valid @RequestParam(value = "time", required = false) OffsetDateTime time,
                @ApiParam(value = "For filtering: A string. Name of the geo location.")
                @Valid @RequestParam(value = "intersection.name", required = false) String intersectionName,
                @ApiParam(value = "For filtering: A string. Type of the geographic location - one of: point, line, graph, ring polygon")
                @Valid @RequestParam(value = "intersection.type", required = false) String intersectionType
        ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                if (fields!=null){
                    return new ResponseEntity<List<RetrieveLocationRelation>>(serviceRLR.list(),HttpStatus.OK);}
                else{
                    List findResurses = new ArrayList();
                    findResurses.add(checkFind(status));
                    findResurses.add(checkFind(locationA));
                    findResurses.add(checkFind(locationB));
                    findResurses.add(checkFind(distance));
                    findResurses.add(checkFind(intersectionName));
                    findResurses.add(checkFind(intersectionType));

                    return new ResponseEntity<List<RetrieveLocationRelation>>(serviceRLR.findByCriteria(findResurses),HttpStatus.OK);
                }
              //  return new ResponseEntity<List<RetrieveLocationRelation>>(objectMapper.readValue("[ {  \"distance\" : \"distance\",  \"geographicLocation\" : {    \"id\" : \"id\",    \"href\" : \"href\"  },  \"intersection\" : [ {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  }, {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  } ],  \"locationA\" : \"locationA\",  \"locationB\" : \"locationB\",  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"status\" : \"status\"}, {  \"distance\" : \"distance\",  \"geographicLocation\" : {    \"id\" : \"id\",    \"href\" : \"href\"  },  \"intersection\" : [ {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  }, {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  } ],  \"locationA\" : \"locationA\",  \"locationB\" : \"locationB\",  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<RetrieveLocationRelation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<RetrieveLocationRelation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RetrieveLocationRelation>> retrieveRetrieveLocationRelation(@ApiParam(value = "Identifier of the Retrieve Location Relation",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<RetrieveLocationRelation>>(serviceRLR.findById(id),HttpStatus.OK);
              //  return new ResponseEntity<List<RetrieveLocationRelation>>(objectMapper.readValue("[ {  \"distance\" : \"distance\",  \"geographicLocation\" : {    \"id\" : \"id\",    \"href\" : \"href\"  },  \"intersection\" : [ {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  }, {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  } ],  \"locationA\" : \"locationA\",  \"locationB\" : \"locationB\",  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"status\" : \"status\"}, {  \"distance\" : \"distance\",  \"geographicLocation\" : {    \"id\" : \"id\",    \"href\" : \"href\"  },  \"intersection\" : [ {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  }, {    \"name\" : \"name\",    \"geographicPoint\" : [ {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    }, {      \"spatialRef\" : \"spatialRef\",      \"x\" : \"x\",      \"accuracy\" : \"accuracy\",      \"y\" : \"y\",      \"z\" : \"z\"    } ],    \"id\" : \"id\",    \"href\" : \"href\",    \"type\" : \"type\"  } ],  \"locationA\" : \"locationA\",  \"locationB\" : \"locationB\",  \"id\" : \"id\",  \"href\" : \"href\",  \"time\" : \"2000-01-23T04:56:07.000+00:00\",  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<RetrieveLocationRelation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<RetrieveLocationRelation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public String checkFind (String input){
        if (input!=null){return input;}
        else{return "%";}
    }

}
