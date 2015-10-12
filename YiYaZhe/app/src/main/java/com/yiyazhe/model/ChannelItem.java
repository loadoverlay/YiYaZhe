package com.yiyazhe.model;

/**
 * 分类列表
 *
 * Author：JiangChu
 * Date：2015/10/11
 */
public class ChannelItem {

    // 栏目对应 ID
    public Integer id;
    // 栏目对应 Name
    public String title;

    public ChannelItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
