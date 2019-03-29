package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-28 20:25
 */
@Data
public class BannerVO implements Serializable {
    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;

    //get、set，使用Lombok-@Data
}