package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-04-13 16:22
 */
@Data
public class CatVO implements Serializable {
    private String catId;
    private String catName;
    private Boolean isActive;
}