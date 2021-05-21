package cn.wfy;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class LApplication {


//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConventers(){
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        converter.setSupportedMediaTypes(mediaTypes);
//        converter.setFastJsonConfig(config);
//
//
//        HttpMessageConverter<?> converter1 = converter;
//        return new HttpMessageConverters(converter1);
//    }


    public static void main(String[] args) {
        SpringApplication.run(LApplication.class, args);
    }

}
