package com.stylefeng.guns.rest.modular.film.vo;

import com.stylefeng.guns.facade.film.vo.BannerVO;
import com.stylefeng.guns.facade.film.vo.FilmInfoVO;
import com.stylefeng.guns.facade.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-28 20:23
 */
@Data
public class FilmIndexVO {
    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfoVO> boxRanking;
    private List<FilmInfoVO> expectRanking;
    private List<FilmInfoVO> top100;
}