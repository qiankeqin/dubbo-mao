package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-04-13 16:23
 */
@Data
public class SourceVO implements Serializable {
    private String sourceId;
    private String sourceName;
    private Boolean isActive;
}