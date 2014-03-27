/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.api;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final Integer DEFAULT_DELETE = new Long(TimeUnit.MINUTES.convert(1, TimeUnit.DAYS)).intValue();

  private String content;

  private Integer delete = DEFAULT_DELETE;

  public Message(String content) {
    this.content = content;
  }

  public Message(String content, Integer delete) {
    this.content = content;
    this.delete = delete;
  }

  public String getContent() {
    return content;
  }

  public Integer getDelete() {
    return delete;
  }

  @Override
  public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
  }

}
