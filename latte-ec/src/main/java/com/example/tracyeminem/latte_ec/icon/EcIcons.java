package com.example.tracyeminem.latte_ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by tracyeminem on 2018/7/15.
 */

public enum  EcIcons implements Icon{
    icon_scan('\ue606'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(Character character){
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace("_","-");
    }

    @Override
    public char character() {
        return character;
    }
}
