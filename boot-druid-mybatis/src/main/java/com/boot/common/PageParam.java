package com.boot.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Description: 分页工具类
 * @Author: yezhiqin
 * @CreateDate: 2018/6/20$ 下午10:15$
 * @Version: 1.0
 */
public class PageParam {
    private int beginLine;       //起始行
    private Integer pageSize = 3;
    private Integer currentPage=0; 	   // 当前页

    public int getBeginLine() {
        return pageSize*currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
