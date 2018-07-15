package com.example.tracyeminem.latte_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by tracyeminem on 2018/7/15.
 */

public class Configurator { //线程安全的懒汉模式，静态内部类

    private static final HashMap<String,Object> LATTE_CONFIG = new HashMap<>(); //如果使用weakhashmap键值对在不使用的时候进行回收

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator(){
            LATTE_CONFIG.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final HashMap<String,Object> getLatteConfig(){
        return LATTE_CONFIG;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        initIcons();
        LATTE_CONFIG.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIG.put(ConfigType.API_HOST.name(),host);
        return this;
    }


    private void initIcons(){
        if(ICONS.size() >0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i =0;i <ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    public void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIG.get(ConfigType.CONFIG_READY.name());//final修饰不再更改，
        if(!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")    //可加可不加，此注解
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIG.get(key.name());
    }

}
