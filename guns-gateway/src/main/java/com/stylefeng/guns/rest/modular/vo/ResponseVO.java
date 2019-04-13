package com.stylefeng.guns.rest.modular.vo;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-18 20:31
 */
public class ResponseVO<M> {
    /**
     * 返回状态
     * 0成功，1失败，999系统异常
     */
    private int status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回实体数据
     */
    private M data;

    private String imgPre;

    private ResponseVO() {
    }

    public static<M> ResponseVO success(String imgPre,M m){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setImgPre(imgPre);
        responseVO.setMsg("成功");
        responseVO.setData(m);
        return responseVO;
    }
    public static<M> ResponseVO success(M m){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg("成功");
        responseVO.setData(m);
        return responseVO;
    }
    public static<M> ResponseVO success(String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static<M> ResponseVO serviceFail(String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static<M> ResponseVO appFail(String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }
}