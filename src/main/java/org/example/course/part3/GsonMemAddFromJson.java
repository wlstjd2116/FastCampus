package org.example.course.part3;

import com.google.gson.Gson;
import org.example.model3.Person;

public class GsonMemAddFromJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"홍길동\",\"age\":30,\"email\":" +
                "\"wlstjd2116@naver.com\",\"address\":{\"city\":\"서울\",\"country\":\"대한민국\"}}";

        Gson gson = new Gson();
        Person person = gson.fromJson(json, Person.class);
        System.out.println("member = " + person);


    }
}
