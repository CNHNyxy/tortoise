package com.datasource.entity.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageVo<T>  extends Page<T> {


    public PageVo() {
        super();
    }

    public PageVo(long current, long size) {
        super(current, size);
    }

    public PageVo(long current, long size, long total) {
        super(current, size, total);
    }

    public PageVo(long current, long size, boolean searchCount) {
        super(current, size, searchCount);
    }

    public PageVo(long current, long size, long total, boolean searchCount) {
        super(current, size, total, searchCount);
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "records=" + records +
                ", total=" + total +
                ", size=" + size +
                ", current=" + current +
                ", maxLimit=" + maxLimit +
                '}';
    }
}
