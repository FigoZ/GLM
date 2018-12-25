package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeographicLocation;
import io.swagger.model.GeographicLocationRef;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This resource is used to manage the request and response to retrieve the relation between two geographic locations. Skipped properties: id,href
 */
@ApiModel(description = "This resource is used to manage the request and response to retrieve the relation between two geographic locations. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

public class RetrieveLocationRelationCreate   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("locationA")
  private String locationA = null;

  @JsonProperty("locationB")
  private String locationB = null;

  @JsonProperty("distance")
  private String distance = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  @JsonProperty("intersection")
  @Valid
  private List<GeographicLocation> intersection = null;

  @JsonProperty("geographicLocation")
  private GeographicLocationRef geographicLocation = null;

  public RetrieveLocationRelationCreate status(String status) {
    this.status = status;
    return this;
  }

  /**
   * A string. Status of the task (inProgress, terminatedWithErrror, done).
   * @return status
  **/
  @ApiModelProperty(value = "A string. Status of the task (inProgress, terminatedWithErrror, done).")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public RetrieveLocationRelationCreate locationA(String locationA) {
    this.locationA = locationA;
    return this;
  }

  /**
   * Reference to a location
   * @return locationA
  **/
  @ApiModelProperty(value = "Reference to a location")


  public String getLocationA() {
    return locationA;
  }

  public void setLocationA(String locationA) {
    this.locationA = locationA;
  }

  public RetrieveLocationRelationCreate locationB(String locationB) {
    this.locationB = locationB;
    return this;
  }

  /**
   * Reference to a location
   * @return locationB
  **/
  @ApiModelProperty(value = "Reference to a location")


  public String getLocationB() {
    return locationB;
  }

  public void setLocationB(String locationB) {
    this.locationB = locationB;
  }

  public RetrieveLocationRelationCreate distance(String distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Calculated distance between location A and location B
   * @return distance
  **/
  @ApiModelProperty(value = "Calculated distance between location A and location B")


  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  public RetrieveLocationRelationCreate time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Timestamp of end of task execution
   * @return time
  **/
  @ApiModelProperty(value = "Timestamp of end of task execution")

  @Valid

  public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public RetrieveLocationRelationCreate intersection(List<GeographicLocation> intersection) {
    this.intersection = intersection;
    return this;
  }

  public RetrieveLocationRelationCreate addIntersectionItem(GeographicLocation intersectionItem) {
    if (this.intersection == null) {
      this.intersection = new ArrayList<GeographicLocation>();
    }
    this.intersection.add(intersectionItem);
    return this;
  }

  /**
   * Get intersection
   * @return intersection
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GeographicLocation> getIntersection() {
    return intersection;
  }

  public void setIntersection(List<GeographicLocation> intersection) {
    this.intersection = intersection;
  }

  public RetrieveLocationRelationCreate geographicLocation(GeographicLocationRef geographicLocation) {
    this.geographicLocation = geographicLocation;
    return this;
  }

  /**
   * Get geographicLocation
   * @return geographicLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GeographicLocationRef getGeographicLocation() {
    return geographicLocation;
  }

  public void setGeographicLocation(GeographicLocationRef geographicLocation) {
    this.geographicLocation = geographicLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrieveLocationRelationCreate retrieveLocationRelationCreate = (RetrieveLocationRelationCreate) o;
    return Objects.equals(this.status, retrieveLocationRelationCreate.status) &&
        Objects.equals(this.locationA, retrieveLocationRelationCreate.locationA) &&
        Objects.equals(this.locationB, retrieveLocationRelationCreate.locationB) &&
        Objects.equals(this.distance, retrieveLocationRelationCreate.distance) &&
        Objects.equals(this.time, retrieveLocationRelationCreate.time) &&
        Objects.equals(this.intersection, retrieveLocationRelationCreate.intersection) &&
        Objects.equals(this.geographicLocation, retrieveLocationRelationCreate.geographicLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, locationA, locationB, distance, time, intersection, geographicLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveLocationRelationCreate {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    locationA: ").append(toIndentedString(locationA)).append("\n");
    sb.append("    locationB: ").append(toIndentedString(locationB)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    intersection: ").append(toIndentedString(intersection)).append("\n");
    sb.append("    geographicLocation: ").append(toIndentedString(geographicLocation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

