package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-04-13 16:25
 */
@Data
public class YearVO implements Serializable {
    private String yearId;
    private String yearName;
    private Boolean isActive;
}