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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This resource is used to manage the request and response to retrieve the relation between two geographic locations.
 * Этот ресурс используется для управления запросом и ответом для получения связи между двумя географическими местоположениями.
 */
@ApiModel(description = "This resource is used to manage the request and response to retrieve the relation between two geographic locations.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Entity
public class RetrieveLocationRelation   {
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

  @JsonProperty("locationA")
  @Column
  private String locationA = null;

  @JsonProperty("locationB")
  @Column
  private String locationB = null;

  @JsonProperty("distance")
  @Column
  private String distance = null;

  @JsonProperty("time")
  @Column
  private OffsetDateTime time = null;

  @JsonProperty("intersection")
  @Valid
  @OneToMany (cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<GeographicLocation> intersection = null;

  @JsonProperty("geographicLocation")
  @OneToOne (cascade = CascadeType.ALL)
  private GeographicLocationRef geographicLocation = null;

  public RetrieveLocationRelation id(String id) {
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

  public RetrieveLocationRelation href(String href) {
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

  public RetrieveLocationRelation status(String status) {
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

  public RetrieveLocationRelation locationA(String locationA) {
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

  public RetrieveLocationRelation locationB(String locationB) {
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

  public RetrieveLocationRelation distance(String distance) {
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

  public RetrieveLocationRelation time(OffsetDateTime time) {
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

  public RetrieveLocationRelation intersection(List<GeographicLocation> intersection) {
    this.intersection = intersection;
    return this;
  }

  public RetrieveLocationRelation addIntersectionItem(GeographicLocation intersectionItem) {
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

  public RetrieveLocationRelation geographicLocation(GeographicLocationRef geographicLocation) {
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
    RetrieveLocationRelation retrieveLocationRelation = (RetrieveLocationRelation) o;
    return Objects.equals(this.id, retrieveLocationRelation.id) &&
        Objects.equals(this.href, retrieveLocationRelation.href) &&
        Objects.equals(this.status, retrieveLocationRelation.status) &&
        Objects.equals(this.locationA, retrieveLocationRelation.locationA) &&
        Objects.equals(this.locationB, retrieveLocationRelation.locationB) &&
        Objects.equals(this.distance, retrieveLocationRelation.distance) &&
        Objects.equals(this.time, retrieveLocationRelation.time) &&
        Objects.equals(this.intersection, retrieveLocationRelation.intersection) &&
        Objects.equals(this.geographicLocation, retrieveLocationRelation.geographicLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, status, locationA, locationB, distance, time, intersection, geographicLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveLocationRelation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

