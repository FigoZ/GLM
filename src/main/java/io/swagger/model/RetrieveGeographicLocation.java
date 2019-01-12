package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeographicLocation;
import org.hibernate.annotations.GenericGenerator;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RetrieveLocation fields
 */
@ApiModel(description = "RetrieveLocation fields")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Entity
public class RetrieveGeographicLocation   {
  @JsonProperty("id")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id = null;

  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonProperty("status")
  @Column
  private String status = null;

  @JsonProperty("requestedAccuracy")
  @Column
  private Float requestedAccuracy = null;

  @JsonProperty("time")
  @Column
  private OffsetDateTime time = null;

  @JsonProperty("geographicLocation")
  @OneToOne(cascade = CascadeType.ALL)
  private GeographicLocation geographicLocation = null;

  @JsonProperty("thing")
  @OneToOne (cascade = CascadeType.ALL)
  private Object thing = null;

  public RetrieveGeographicLocation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A string. Unique identifier of the task.
   * @return id
  **/
  @ApiModelProperty(value = "A string. Unique identifier of the task.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RetrieveGeographicLocation href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A string. An URI used to access to the task resource.
   * @return href
  **/
  @ApiModelProperty(value = "A string. An URI used to access to the task resource.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public RetrieveGeographicLocation status(String status) {
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

  public RetrieveGeographicLocation requestedAccuracy(Float requestedAccuracy) {
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

  public RetrieveGeographicLocation time(OffsetDateTime time) {
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

  public RetrieveGeographicLocation geographicLocation(GeographicLocation geographicLocation) {
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

  public RetrieveGeographicLocation thing(Object thing) {
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
    RetrieveGeographicLocation retrieveGeographicLocation = (RetrieveGeographicLocation) o;
    return Objects.equals(this.id, retrieveGeographicLocation.id) &&
        Objects.equals(this.href, retrieveGeographicLocation.href) &&
        Objects.equals(this.status, retrieveGeographicLocation.status) &&
        Objects.equals(this.requestedAccuracy, retrieveGeographicLocation.requestedAccuracy) &&
        Objects.equals(this.time, retrieveGeographicLocation.time) &&
        Objects.equals(this.geographicLocation, retrieveGeographicLocation.geographicLocation) &&
        Objects.equals(this.thing, retrieveGeographicLocation.thing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, status, requestedAccuracy, time, geographicLocation, thing);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveGeographicLocation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

