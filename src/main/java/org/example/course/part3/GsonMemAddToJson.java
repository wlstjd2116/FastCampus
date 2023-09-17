package org.example.course.part3;

import com.google.gson.Gson;
import org.example.model3.Address;
import org.example.model3.Person;

public class GsonMemAddToJson {
    public static void main(String[] args) {
        Address address = new Address("서울", "대한민국");
        Person person = new Person("홍길동",30,"wlstjd2116@naver.com", address);

        // Person -> JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println("json : " + json);
    }
}
