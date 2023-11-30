package com.startdis.comm.kits.object;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc ObjectKits 对象工具箱
 */
public class ObjectKits {

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return: boolean
     */
    public static boolean isEmpty(Object object) {
        boolean aNull = isNull(object);
        if(!aNull){
            //普通的类对象
            Field[] fields = object.getClass().getDeclaredFields();
            //先假设全部属性都是空的，所以只要出现一个属性不为空的就不需要在循环判断
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!"serialVersionUID".equals(field.getName()) && !ObjectKits.isNull(field.get(object))) {
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return: boolean
     */
    public static boolean isNull(Object object) {
        //判断对象是否为null
        if (null == object) {
            return true;
        }
        //判断对象是否为容器对象类型
        if (object instanceof Optional) {
            return !((Optional) object).isPresent();
        }
        //判断对象是否为字符集合类型
        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }
        //判断对象是否为数组类型
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        //判断对象是否为集合类型
        if (object instanceof Collection) {
            return ((Collection) object).isEmpty();
        }
        //判断对象是否为Map
        return object instanceof Map ? ((Map) object).isEmpty() : false;
    }

    /**
     * 判断obejct对象中除了names里面的字段，其他字段都为null（已知对象类型）
     *
     * @param object
     * @param names
     * @return
     */
    public static boolean isEmpty(Object object, String... names) {
        Field[] fields = object.getClass().getDeclaredFields();
        //用于判断所有属性是否为空,如果参数为空则不查询
        boolean flag = true;
        for (Field field : fields) {
            //不检查 直接取值
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                List<String> nameList = new ArrayList<>();
                if (null != names && names.length != 0) {
                    nameList = Arrays.asList(names);
                }
                if (!nameList.contains(fieldName) && !Objects.isNull(field.get(object))) {
                    //不为空
                    flag = false;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 判断object对象中除了names里面的字段，其他字段都为null或者是""（已知对象类型）
     *
     * @param object
     * @param names
     * @return
     */
    public static boolean isBlank(Object object, String... names) {
        Field[] fields = object.getClass().getDeclaredFields();
        //用于判断所有属性是否为空,如果参数为空则不查询
        boolean flag = true;
        for (Field field : fields) {
            //不检查 直接取值
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                List<String> nameList = new ArrayList<>();
                if (null != names && names.length != 0) {
                    nameList = Arrays.asList(names);
                }
                Object value = field.get(object);
                if (!nameList.contains(fieldName) && !isEmpty(value)) {
                    //不为空
                    flag = false;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
