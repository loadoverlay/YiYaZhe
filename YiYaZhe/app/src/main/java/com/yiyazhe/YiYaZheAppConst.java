package com.yiyazhe;

import com.yiyazhe.model.ChannelItem;

import java.util.ArrayList;

/**
 * 应用常量
 *
 * Author：JiangChu
 * Date：2015/10/11
 */
public class YiYaZheAppConst {

    // 软件版本名称
    public static final String app_version_name = "1.0";

    // 软件版本号
    public static final int app_version_code = 1;

    public static final String SERVER_URL = "http://yiyazhe.com/Index/";



    public static ArrayList<ChannelItem> getData() {
        ArrayList<ChannelItem> channelItems = new ArrayList<ChannelItem>();
        ChannelItem channelItem = new ChannelItem();
        channelItem.setId(0);
        channelItem.setTitle("最新折扣");
        channelItems.add(channelItem);
        channelItem = new ChannelItem();
        channelItem.setId(1);
        channelItem.setTitle("昨日上新");
        channelItems.add(channelItem);
        channelItem = new ChannelItem();
        channelItem.setId(2);
        channelItem.setTitle("9.9包邮");
        channelItems.add(channelItem);
        channelItem = new ChannelItem();
        channelItem.setId(3);
        channelItem.setTitle("热门排名");
        channelItems.add(channelItem);
        channelItem = new ChannelItem();
        channelItem.setId(4);
        channelItem.setTitle("明日预告");
        channelItems.add(channelItem);
        return channelItems;
    }
}
