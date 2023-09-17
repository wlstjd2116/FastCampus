package org.example.course.part3;

import com.google.gson.Gson;
import org.example.model3.Member;

public class GsontoJson {
    public static void main(String[] args) {
        Member mvo = new Member("홍길동", 30, "eam@exm.com");
        // JSON -> {"name" : 홍길동, "age": 30, "email": "eam@exm.com"}

        //객체 생성
        Gson gson = new Gson();

        //Object(Member) => JSON
        String json = gson.toJson(mvo);
        System.out.println("json = "+ json);
    }
}
