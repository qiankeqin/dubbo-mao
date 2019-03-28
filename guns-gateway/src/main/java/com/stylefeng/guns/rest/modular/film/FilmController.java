package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-27 21:49
 */
@RestController
@RequestMapping("/film/")
public class FilmController {

    /**
     * 获取首页信息接口
     * api聚合
     * @return
     */
    @GetMapping("getIndex")
    public ResponseVO getIndex(){
        //获取Banner信息

        //获取热映电影

        //获取即将上映的电影

        //获取票房排行榜

        //获取受欢迎的榜单

        //获取top100



        return null;
    }
}