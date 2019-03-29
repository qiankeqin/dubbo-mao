package com.stylefeng.guns.facade.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-28 20:30
 */
@Data
public class FilmVO  implements Serializable {
    private int filmNum;
    private List<FilmInfoVO> filmInfo;
}