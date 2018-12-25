package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeographicLocation;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RetrieveLocation fields Skipped properties: id,href
 */
@ApiModel(description = "RetrieveLocation fields Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

public class RetrieveGeographicLocationCreate   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("requestedAccuracy")
  private Float requestedAccuracy = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  @JsonProperty("geographicLocation")
  private GeographicLocation geographicLocation = null;

  @JsonProperty("thing")
  private Object thing = null;

  public RetrieveGeographicLocationCreate status(String status) {
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

  public RetrieveGeographicLocationCreate requestedAccuracy(Float requestedAccuracy) {
    this.requestedAccuracy = requestedAccuracy;
    return this;
  }

  /**
   * Requested accuracy of the retrieval
   * @return requestedAccuracy
  **/
  @ApiModelProperty(value = "Requested accuracy of the retrieval")


  public Float getRequestedAccuracy() {
    return requestedAccuracy;
  }

  public void setRequestedAccuracy(Float requestedAccuracy) {
    this.requestedAccuracy = requestedAccuracy;
  }

  public RetrieveGeographicLocationCreate time(OffsetDateTime time) {
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

  public RetrieveGeographicLocationCreate geographicLocation(GeographicLocation geographicLocation) {
    this.geographicLocation = geographicLocation;
    return this;
  }

  /**
   * Get geographicLocation
   * @return geographicLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GeographicLocation getGeographicLocation() {
    return geographicLocation;
  }

  public void setGeographicLocation(GeographicLocation geographicLocation) {
    this.geographicLocation = geographicLocation;
  }

  public RetrieveGeographicLocationCreate thing(Object thing) {
    this.thing = thing;
    return this;
  }

  /**
   * Get thing
   * @return thing
  **/
  @ApiModelProperty(value = "")


  public Object getThing() {
    return thing;
  }

  public void setThing(Object thing) {
    this.thing = thing;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrieveGeographicLocationCreate retrieveGeographicLocationCreate = (RetrieveGeographicLocationCreate) o;
    return Objects.equals(this.status, retrieveGeographicLocationCreate.status) &&
        Objects.equals(this.requestedAccuracy, retrieveGeographicLocationCreate.requestedAccuracy) &&
        Objects.equals(this.time, retrieveGeographicLocationCreate.time) &&
        Objects.equals(this.geographicLocation, retrieveGeographicLocationCreate.geographicLocation) &&
        Objects.equals(this.thing, retrieveGeographicLocationCreate.thing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, requestedAccuracy, time, geographicLocation, thing);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveGeographicLocationCreate {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    requestedAccuracy: ").append(toIndentedString(requestedAccuracy)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    geographicLocation: ").append(toIndentedString(geographicLocation)).append("\n");
    sb.append("    thing: ").append(toIndentedString(thing)).append("\n");
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

