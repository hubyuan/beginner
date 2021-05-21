package cn.wfy.testController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@Configuration
public class CustomFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {
    public final static Charset UTF8 = Charset.forName("UTF-8");
    private Charset charset = UTF8;
    private ToStringSerializeFilter toStringSerializeFilter = new ToStringSerializeFilter();

    // 重写这个方法

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {

        OutputStream out = outputMessage.getBody();

        // 转json时 加入自定义的Filter
        String text = JSON.toJSONString(obj, toStringSerializeFilter, features);

        byte[] bytes = text.getBytes(charset);

        out.write(bytes);

    }
}
