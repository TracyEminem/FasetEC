package com.example.tracyeminem.latte_core.app;

/**
 * Created by tracyeminem on 2018/7/15.
 */

public enum ConfigType { //只能初始化一次，唯一的单例，惰性单例。懒汉模式，多线程操作可以使用
    API_HOST,
    APPLICATION_CONTEXT, //全局context
    CONFIG_READY,
    ICON


}
