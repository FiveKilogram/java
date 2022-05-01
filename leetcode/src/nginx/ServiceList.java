/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package nginx;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/5/7
 */
public class ServiceList {

    public static  Map<String, Integer> weight_list = new LinkedHashMap<>();
    static {
        weight_list.put("A", 5);
        weight_list.put("B", 1);
        weight_list.put("C", 1);
    }
}
