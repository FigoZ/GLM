package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.GeographicLocation;
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
public class GeographicLocationApiController implements GeographicLocationApi {

    private static final Logger log = LoggerFactory.getLogger(GeographicLocationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GeographicLocationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<GeographicLocation>> listGeographicLocation(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "For filtering: A string. Name of the geo location.") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "For filtering: A string. Type of the geographic location - one of: point, line, graph, ring polygon") @Valid @RequestParam(value = "type", required = false) String type,@ApiParam(value = "For filtering: A string. Accuracy of the coordinate specified.") @Valid @RequestParam(value = "geographicPoint.accuracy", required = false) String geographicPointAccuracy,@ApiParam(value = "For filtering: A string. Geocoding referential.") @Valid @RequestParam(value = "geographicPoint.spatialRef", required = false) String geographicPointSpatialRef,@ApiParam(value = "For filtering: A string. x coordinate (usually latitude).") @Valid @RequestParam(value = "geographicPoint.x", required = false) String geographicPointX,@ApiParam(value = "For filtering: A string. y coordinate (usually longitude).") @Valid @RequestParam(value = "geographicPoint.y", required = false) String geographicPointY,@ApiParam(value = "For filtering: A string. z coordinate (usually elevation).") @Valid @RequestParam(value = "geographicPoint.z", required = false) String geographicPointZ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<GeographicLocation>>(objectMapper.readValue("[ {  \"name\" : \"name\",  \"geographicPoint\" : [ {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  }, {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"type\" : \"type\"}, {  \"name\" : \"name\",  \"geographicPoint\" : [ {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  }, {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"type\" : \"type\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<GeographicLocation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<GeographicLocation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<GeographicLocation>> retrieveGeographicLocation(@ApiParam(value = "Identifier of the Geographic Location",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<GeographicLocation>>(objectMapper.readValue("[ {  \"name\" : \"name\",  \"geographicPoint\" : [ {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  }, {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"type\" : \"type\"}, {  \"name\" : \"name\",  \"geographicPoint\" : [ {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  }, {    \"spatialRef\" : \"spatialRef\",    \"x\" : \"x\",    \"accuracy\" : \"accuracy\",    \"y\" : \"y\",    \"z\" : \"z\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"type\" : \"type\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<GeographicLocation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<GeographicLocation>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
