package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.facade.film.FilmServiceApi;
import com.stylefeng.guns.facade.film.vo.BannerVO;
import com.stylefeng.guns.facade.film.vo.FilmInfoVO;
import com.stylefeng.guns.facade.film.vo.FilmVO;
import com.stylefeng.guns.rest.common.persistence.dao.MoocBannerTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MoocFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocBannerT;
import com.stylefeng.guns.rest.common.persistence.model.MoocFilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-29 13:13
 */
@Component
@Service(interfaceClass = FilmServiceApi.class)
public class DefaultFilmServiceImpl implements FilmServiceApi {

    @Autowired
    private MoocBannerTMapper moocBannerTMapper;

    @Autowired
    private MoocFilmTMapper moocFilmTMapper;

    @Override
    public List<BannerVO> getBanners() {
        List<MoocBannerT> moocBanners = moocBannerTMapper.selectList(null);
        List<BannerVO> bannerVOList = new ArrayList<>();
        for (MoocBannerT moocBanner : moocBanners) {
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerId(moocBanner.getUuid()+"");
            bannerVO.setBannerUrl(moocBanner.getBannerUrl());
            bannerVO.setBannerAddress(moocBanner.getBannerAddress());
            bannerVOList.add(bannerVO);
        }
        return bannerVOList;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> filmInfos = new ArrayList<>();

        //热映影片的限制条件
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");
        List<MoocFilmT> moocFilmTList = new ArrayList<>();
        //判断是否是首页需要的内容
        if(isLimit){
            //如果是，则限制条数
            Page<MoocFilmT> page = new Page<>(1,nums);
            moocFilmTList = moocFilmTMapper.selectPage(page, entityWrapper);
        } else {
            //如果不是，则不进行限制
            moocFilmTList = moocFilmTMapper.selectList(entityWrapper);
        }
        if(CollectionUtils.isEmpty(moocFilmTList)){
            moocFilmTList = new ArrayList<>();
        }
        filmInfos = getFilmInfos(moocFilmTList);
        filmVO.setFilmInfo(filmInfos);
        filmVO.setFilmNum(moocFilmTList.size());
        return filmVO;
    }

    private List<FilmInfoVO> getFilmInfos(List<MoocFilmT> moocFilms){
        List<FilmInfoVO> filmInfos = new ArrayList<>();
        for (MoocFilmT moocFilmT : moocFilms) {
            FilmInfoVO filmInfoVO = new FilmInfoVO();
            filmInfoVO.setScore(moocFilmT.getFilmScore());
            filmInfoVO.setShowTime(DateUtil.getDay(moocFilmT.getFilmTime()));
            filmInfoVO.setImgAddress(moocFilmT.getImgAddress());
            filmInfoVO.setFilmType(moocFilmT.getFilmType());
            filmInfoVO.setFilmName(moocFilmT.getFilmName());
            filmInfoVO.setExpectNum(moocFilmT.getFilmPresalenum());
            filmInfoVO.setBoxNum(moocFilmT.getFilmBoxOffice());
            filmInfoVO.setFilmId(moocFilmT.getUuid()+"");
            filmInfos.add(filmInfoVO);
        }
        return filmInfos;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> filmInfos = new ArrayList<>();

        //热映影片的限制条件
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");
        List<MoocFilmT> moocFilmTList = new ArrayList<>();
        //判断是否是首页需要的内容
        if(isLimit){
            //如果是，则限制条数
            Page<MoocFilmT> page = new Page<>(1,nums);
            moocFilmTList = moocFilmTMapper.selectPage(page, entityWrapper);
        } else {
            //如果不是，则不进行限制
            moocFilmTList = moocFilmTMapper.selectList(entityWrapper);
        }
        if(CollectionUtils.isEmpty(moocFilmTList)){
            moocFilmTList = new ArrayList<>();
        }
        filmInfos = getFilmInfos(moocFilmTList);
        filmVO.setFilmInfo(filmInfos);
        filmVO.setFilmNum(moocFilmTList.size());
        return filmVO;
    }

    @Override
    public List<FilmInfoVO> getBoxRanking() {
        //票房前十名
        return null;
    }

    @Override
    public List<FilmInfoVO> getExpectRanking() {
        //经典影片
        return null;
    }

    @Override
    public List<FilmInfoVO> getTop() {
        //评分前十名
        return null;
    }
}