package com.stylefeng.guns.facade.film;

import com.stylefeng.guns.facade.film.vo.BannerVO;
import com.stylefeng.guns.facade.film.vo.FilmInfoVO;
import com.stylefeng.guns.facade.film.vo.FilmVO;

import java.util.List;

/**
 * @author qiankeqin
 * @Description: 影片的Api接口
 * @date 2019-03-28 20:45
 */
public interface FilmServiceApi {
    //获取banners
    List<BannerVO> getBanners();
    //获取热映影片
    FilmVO getHotFilms(boolean isLimit,int nums);
    //获取即将上映影片
    FilmVO getSoonFilms(boolean isLimit,int nums);
    //获取票房排行榜
    List<FilmInfoVO> getBoxRanking();
    //获取人气排行榜
    List<FilmInfoVO> getExpectRanking();
    //获取top100
    List<FilmInfoVO> getTop();
}