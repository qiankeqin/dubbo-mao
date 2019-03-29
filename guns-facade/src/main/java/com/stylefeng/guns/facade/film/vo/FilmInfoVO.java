package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-28 20:30
 */
@Data
public class FilmInfoVO  implements Serializable {
    private String filmId;
    private int filmType;
    private String filmName;
    private String imgAddress;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;
}