package com.example.exercisemorning;
import com.Cloudinary.Cloudinary;
import com.Cloudinary.Transformation;
import groovy.lang.Singleton;
import org.apache.tomcat.websocket.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CloudinaryConfig {
    private CloudinaryConfig(@Value("${cloudinary.apikey}") String key,
                             @Value("${cloudinary.apisecret}")String secret,
                             @Value("${cloudinery.cloudname}")String cloud)
    {
     cloudinary=Singleton.getCloudinary();
     cloudinary.config.cloudName=cloud;
     cloudinary.config.apiSecret=secret;
     cloudinary.config.apiKey=key;
     System.out.println("cloud name:+cloud");

    }
    public Map upload(Object file,Map options)
    {
        try {
            return cloudinary.uploader().upload(file, options);
        }catch(IOException e)
        {
         e.printStackTrace();
         return null;
        }
    }
    public String creatURL(String name) {
        return cloudinary.url().transformation(
                new Transformation().Width(100).crop("fill").radius(50).gravity("face")).generate(url);
    }
    public String crreateURL(String name,int width,int height)
    {
        return cloudinary.url().transformation(new Transformation(new Transformation().width(width).height(height).radius(50).gravity("face"))
                .type("fill").radius(50).gravity("face")).type("fetch").generate(url);

    }

}
