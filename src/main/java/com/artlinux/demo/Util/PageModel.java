package com.artlinux.demo.Util;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class PageModel implements Serializable {

    // 共20条3页、首页、上一页、下一页、尾页、一页展示数量、当前页

    // 当前页
    private Integer currentPage;
    // 页码步长
    private Integer StepSize;
    // 首页
    private Integer homePage = 1;
    // 尾页
    private Integer trailerPage;
    // 总页数
    private Integer pageCount = 0;
    // 总条数
    private Integer totalNumber = 0;

    // 分页查询-从第几条数据开始查询
    private Integer queryNumber = 0;

    private Map<String, Object> map;

    // 分类--模板外内容，复制即可删掉
    private Integer typeId;

    // 分类--模板外内容，复制即可删掉
    private Integer state;

    /**
     * 根据参数补全其他参数
     * 
     * @param currentPage
     * @param stepSize
     * @param number
     */
    public PageModel(Integer currentPage, Integer stepSize, int number) {

        this.currentPage = currentPage;
        this.StepSize = stepSize;
        this.totalNumber = number;
        this.trailerPage = number / stepSize + 1;
        this.pageCount = number / stepSize + 1;
        this.queryNumber = (currentPage - 1) * stepSize;
    }

    /**
     * 根据参数补全其他参数
     * 
     * @param currentPage
     * @param stepSize
     * @param number
     * @param map
     */
    public PageModel(Integer currentPage, Integer stepSize, int number, Map<String, Object> map) {

        this.currentPage = currentPage;
        this.StepSize = stepSize;
        this.totalNumber = number;
        this.trailerPage = number / stepSize + 1;
        this.pageCount = number / stepSize + 1;
        this.queryNumber = (currentPage - 1) * stepSize;
        this.map = map;
    }

    public PageModel(Integer currentPage, Integer stepSize, Integer homePage, Integer trailerPage, Integer pageCount,
            Integer totalNumber, Integer queryNumber, Map<String, Object> map, Integer typeId, Integer state) {
        this.currentPage = currentPage;
        this.StepSize = stepSize;
        this.homePage = homePage;
        this.trailerPage = trailerPage;
        this.pageCount = pageCount;
        this.totalNumber = totalNumber;
        this.queryNumber = queryNumber;
        this.map = map;
        this.typeId = typeId;
        this.state = state;
    }

    public PageModel() {

    }

    @Override
    public String toString() {
        return "PageModel{" +
                "currentPage=" + currentPage +
                ", stepSize=" + StepSize +
                ", homePage=" + homePage +
                ", trailerPage=" + trailerPage +
                ", pageCount=" + pageCount +
                ", totalNumber=" + totalNumber +
                ", queryNumber=" + queryNumber +
                ", map=" + map +
                ", typeId=" + typeId +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PageModel pageModel = (PageModel) o;
        return Objects.equals(currentPage, pageModel.currentPage) &&
                Objects.equals(StepSize, pageModel.StepSize) &&
                Objects.equals(homePage, pageModel.homePage) &&
                Objects.equals(trailerPage, pageModel.trailerPage) &&
                Objects.equals(pageCount, pageModel.pageCount) &&
                Objects.equals(totalNumber, pageModel.totalNumber) &&
                Objects.equals(queryNumber, pageModel.queryNumber) &&
                Objects.equals(map, pageModel.map) &&
                Objects.equals(typeId, pageModel.typeId) &&
                Objects.equals(state, pageModel.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPage, StepSize, homePage, trailerPage, pageCount, totalNumber, queryNumber, map,
                typeId, state);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStepSize() {
        return StepSize;
    }

    public void setStepSize(Integer stepSize) {
        this.StepSize = stepSize;
    }

    public Integer getHomePage() {
        return homePage;
    }

    public void setHomePage(Integer homePage) {
        this.homePage = homePage;
    }

    public Integer getTrailerPage() {
        return trailerPage;
    }

    public void setTrailerPage(Integer trailerPage) {
        this.trailerPage = trailerPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(Integer queryNumber) {
        this.queryNumber = queryNumber;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
