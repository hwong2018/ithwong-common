package com.ithwong.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @description 存储分页信息的实体
 * Created by Harry on 2017/7/18.
 */
public class Page<T> implements Serializable {
    private Long totalCount;
    private Integer pageNo;
    private Integer pageSize;
    private List<T> resultList;
    private boolean firstPage;
    private boolean lastPage;
    private T condition;    //该对象的查询条件

    public Page() { }

    public Page(Long totalCount, Integer pageNo, Integer pageSize, List<T> resultList, boolean firstPage, boolean lastPage, T condition) {
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.resultList = resultList;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.condition = condition;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", resultList=" + resultList +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", condition=" + condition +
                '}';
    }
}
