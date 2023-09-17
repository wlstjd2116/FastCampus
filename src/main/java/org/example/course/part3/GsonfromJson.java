package org.example.course.part3;

import com.google.gson.Gson;
import org.example.model3.Member;

public class GsonfromJson {
    public static void main(String[] args) {
        // java에서 ""는 문자열로 인식하기 때문에 역슬래쉬 + " 를 해줌으로써 문자열을 의미하는 것이 아니라는 것을 명시
        String json = "{\"name\":\"홍길동\",\"age\":30,\"email\":\"eam@exm.com\"}";

        // JSON -> Object(Member)
        Gson gson = new Gson();
        Member mvo = gson.fromJson(json, Member.class);
        System.out.println("mvo =" + mvo); //mvo.tpString(): Member{name='홍길동', age=30, email='eam@exm.com'}
    }
}
