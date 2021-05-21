package cn.wfy.testController;


import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigInteger;

public class ToStringSerializeFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {

        if (value != null) {
            // 当value不为null时，如果value是Long类型的就改成String
            if (value instanceof Long) {
                return value.toString();
            }
            if (value instanceof BigInteger) {
                return value.toString();
            }
        }
        return value;
    }

}