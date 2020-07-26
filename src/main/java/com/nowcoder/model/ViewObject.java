package com.nowcoder.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rainday on 16/6/30.
 */
//内置一个map来存放视图对象（object，String)
    //使用它的作用是，我们前端拿数据，那么这里面的数据可能是文字图片或者其他的
    //因此我们需要一个类来完整的存储这些东西在这个对象里。
public class ViewObject {
    private Map<String ,Object> objs= new HashMap<String,Object>();
    public void set(String key,Object value){objs.put(key, value);}
    public Object get(String key,Object value){
        return objs.get(key);
    }
    public Object get(String key) {
        return objs.get(key);
    }
}
