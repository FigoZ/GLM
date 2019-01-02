package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A GeoPoint defines a geographic point through coordinates.
 * Географическая точка с координатами
 */
@ApiModel(description = "A GeoPoint defines a geographic point through coordinates.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")

@Entity
public class GeographicPoint extends BasePojo  {

  @JsonProperty("accuracy")  //точность
 @Column
  private String accuracy = null;

  @JsonProperty("spatialRef") //пространственный ref
  @Column
  private String spatialRef = null;

  @JsonProperty("x")
  @Column
  private String x = null;

  @JsonProperty("y")
  @Column
  private String y = null;

  @JsonProperty("z")
  @Column
  private String z = null;

  public GeographicPoint accuracy(String accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * A string. Accuracy of the coordinate specified.
   * @return accuracy
  **/
  @ApiModelProperty(value = "A string. Accuracy of the coordinate specified.")


  public String getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(String accuracy) {
    this.accuracy = accuracy;
  }

  public GeographicPoint spatialRef(String spatialRef) {
    this.spatialRef = spatialRef;
    return this;
  }

  /**
   * A string. Geocoding referential.
   * @return spatialRef
  **/
  @ApiModelProperty(value = "A string. Geocoding referential.")


  public String getSpatialRef() {
    return spatialRef;
  }

  public void setSpatialRef(String spatialRef) {
    this.spatialRef = spatialRef;
  }

  public GeographicPoint x(String x) {
    this.x = x;
    return this;
  }

  /**
   * A string. x coordinate (usually latitude).
   * @return x
  **/
  @ApiModelProperty(value = "A string. x coordinate (usually latitude).")


  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public GeographicPoint y(String y) {
    this.y = y;
    return this;
  }

  /**
   * A string. y coordinate (usually longitude).
   * @return y
  **/
  @ApiModelProperty(value = "A string. y coordinate (usually longitude).")


  public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  public GeographicPoint z(String z) {
    this.z = z;
    return this;
  }

  /**
   * A string. z coordinate (usually elevation).
   * @return z
  **/
  @ApiModelProperty(value = "A string. z coordinate (usually elevation).")


  public String getZ() {
    return z;
  }

  public void setZ(String z) {
    this.z = z;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicPoint geographicPoint = (GeographicPoint) o;
    return Objects.equals(this.accuracy, geographicPoint.accuracy) &&
        Objects.equals(this.spatialRef, geographicPoint.spatialRef) &&
        Objects.equals(this.x, geographicPoint.x) &&
        Objects.equals(this.y, geographicPoint.y) &&
        Objects.equals(this.z, geographicPoint.z);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accuracy, spatialRef, x, y, z);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicPoint {\n");
    
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    spatialRef: ").append(toIndentedString(spatialRef)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    z: ").append(toIndentedString(z)).append("\n");
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

