package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeographicPoint;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Structured textual way of describing a geographic location. A geographic location allows describing through coordinate(s), a point, a line or a space.
 * Структурированный текстовый способ описания географического положения.
 * Географическое положение позволяет описывать с помощью координат (ы), точки, линии или пространства.
 */
@ApiModel(description = "Structured textual way of describing a geographic location. A geographic location allows describing through coordinate(s), a point, a line or a space.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Entity
public class GeographicLocation   {
  @JsonProperty("id")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id = null;

  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonProperty("name")
  @Column
  private String name = null;

  @JsonProperty("type")
  @Column
  private String type = null;

  @JsonProperty("geographicPoint")
  @Valid
  //@ElementCollection
  @OneToMany (cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<GeographicPoint> geographicPoint = null;

  public GeographicLocation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A string. Unique identifier of the geographic location.
   * @return id
  **/
  @ApiModelProperty(value = "A string. Unique identifier of the geographic location.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GeographicLocation href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A string. An URI used to access to the geographic location resource.
   * @return href
  **/
  @ApiModelProperty(value = "A string. An URI used to access to the geographic location resource.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public GeographicLocation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A string. Name of the geo location.
   * @return name
  **/
  @ApiModelProperty(value = "A string. Name of the geo location.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GeographicLocation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A string. Type of the geographic location - one of: point, line, graph, ring polygon
   * @return type
  **/
  @ApiModelProperty(value = "A string. Type of the geographic location - one of: point, line, graph, ring polygon")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeographicLocation geographicPoint(List<GeographicPoint> geographicPoint) {
    this.geographicPoint = geographicPoint;
    return this;
  }

  public GeographicLocation addGeographicPointItem(GeographicPoint geographicPointItem) {
    if (this.geographicPoint == null) {
      this.geographicPoint = new ArrayList<GeographicPoint>();
    }
    this.geographicPoint.add(geographicPointItem);
    return this;
  }

  /**
   * Get geographicPoint
   * @return geographicPoint
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GeographicPoint> getGeographicPoint() {
    return geographicPoint;
  }

  public void setGeographicPoint(List<GeographicPoint> geographicPoint) {
    this.geographicPoint = geographicPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicLocation geographicLocation = (GeographicLocation) o;
    return Objects.equals(this.id, geographicLocation.id) &&
        Objects.equals(this.href, geographicLocation.href) &&
        Objects.equals(this.name, geographicLocation.name) &&
        Objects.equals(this.type, geographicLocation.type) &&
        Objects.equals(this.geographicPoint, geographicLocation.geographicPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, type, geographicPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicLocation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    geographicPoint: ").append(toIndentedString(geographicPoint)).append("\n");
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

