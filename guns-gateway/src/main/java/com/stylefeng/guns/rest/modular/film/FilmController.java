package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.facade.film.FilmServiceApi;
import com.stylefeng.guns.facade.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-27 21:49
 */
@RestController
@RequestMapping("/film/")
public class FilmController {

    private final static String IMG_PRE = "";

    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    /**
     * 获取首页信息接口
     * api聚合
     * @return
     */
    @GetMapping("getIndex")
    public ResponseVO getIndex(){
        FilmIndexVO filmIndexVO = new FilmIndexVO();
        //获取Banner信息
        filmIndexVO.setBanners(filmServiceApi.getBanners());
        //获取热映电影
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true,8));
        //获取即将上映的电影
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true,8));
        //获取票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());
        //获取受欢迎的榜单
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());
        //获取top100
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(IMG_PRE,filmIndexVO);
    }

    @GetMapping("getConditionList")
    public ResponseVO getConditionList(@RequestParam(name="catId",defaultValue = "99",required = false) String catId,
                                       @RequestParam(name="sourceId",defaultValue = "99",required = false) String sourceId,
                                       @RequestParam(name="yearId",defaultValue = "99",required = false) String yearId){
        //类型集合

        //片源

        //年代
        return null;
    }
}