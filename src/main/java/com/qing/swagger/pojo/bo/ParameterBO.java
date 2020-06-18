package com.qing.swagger.pojo.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author yuanqing
 * @since 2020/6/18
 */
@Data
public class ParameterBO {

    private String name;
    private String in;
    private String description;
    private Boolean required;
    private String type;
    private String format;
    @JsonProperty("x-example")
    private Object example;

}
