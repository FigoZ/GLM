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
 * Defines a geographic location and/or identifies an existing geographic location entity A geographic Location allows describing through coordinate(s) a point, a line or a space.
 */
@ApiModel(description = "Defines a geographic location and/or identifies an existing geographic location entity A geographic Location allows describing through coordinate(s) a point, a line or a space.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:02:40.482+03:00")


public class GeographicLocationRef   {
  @JsonProperty("id")

  private String id = null;

  @JsonProperty("href")

  private String href = null;

  public GeographicLocationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A String
   * @return id
  **/
  @ApiModelProperty(value = "A String")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GeographicLocationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A String
   * @return href
  **/
  @ApiModelProperty(value = "A String")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicLocationRef geographicLocationRef = (GeographicLocationRef) o;
    return Objects.equals(this.id, geographicLocationRef.id) &&
        Objects.equals(this.href, geographicLocationRef.href);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicLocationRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

