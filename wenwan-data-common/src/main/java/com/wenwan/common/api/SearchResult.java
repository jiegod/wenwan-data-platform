package com.wenwan.common.api;

import java.util.List;

public class SearchResult<T> {
    private long total;
    private List<T> rows;

    public SearchResult(){
        super();
    }

    public SearchResult(List<T> rows, long total){
        super();
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
