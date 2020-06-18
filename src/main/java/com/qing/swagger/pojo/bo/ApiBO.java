package com.qing.swagger.pojo.bo;

import lombok.Data;

import java.util.List;

/**
 * @author yuanqing
 * @since 2020/6/18
 */

@Data
public class ApiBO {

    private String url;
    private String method;
    private String tag;
    private List<ParameterBO> parameters;
    private Object response;

}
