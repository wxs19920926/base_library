package com.library.android.mylibrary.baseUtil;

import java.util.List;

/**
 * Created by wxs on 2019/4/4.
 */

public class TestUtil {
    /**
     * 空验证
     */
    public static boolean isNotNull(Object object) {
        if(null != object) {
            if (object instanceof String) {
                return !"".equals(((String) object).trim());
            }else if(object instanceof List) {
                return ((List) object).size() > 0;
            }else {
                if(null != object) {
                    return true;
                }
            }
        }else {
            return false;
        }
        return false;
    }
}
