package com.utils;

import java.util.List;

/**
 * Created by Administrator on 2019/7/23.
 */
public class Page {
    private Integer pageSize;
    private Integer pageNo;
    private Integer rows;
    private Integer pageTotal;
    private List<?> list;
    public Page(Integer pageSize, Integer pageNo, Integer rows) {
        this.pageSize = pageSize;
        this.rows = rows;
        this.pageTotal =rows%pageSize==0?rows/pageSize:rows/pageSize+1;
        if(this.pageTotal>0){
            if(pageNo<1){
                this.pageNo=1;
            }else if(pageNo>this.pageTotal){
                this.pageNo=this.pageTotal;
            }else {
                this.pageNo=pageNo;
            }
        }else {
            this.pageNo=1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }
    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
