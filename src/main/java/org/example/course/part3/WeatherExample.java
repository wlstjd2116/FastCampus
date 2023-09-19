package org.example.course.part3;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

public class WeatherExample {
    public static void main(String[] args) {
        String apiKey = "3a9f3bb7c7d1d2eed505e0a866db90aa";
        String city = "Seoul";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // 연결 객체를 connection으로 넘겨줌.
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json"); // 요청 시 json 으로 받음

            int responseCode = connection.getResponseCode(); // 200
            if (responseCode == 200){
                // 스트림(stream = 입력, 출력)의 연결
                // inputStreamReader의 경우 문자 단위로 받아들이기(한글로 인코딩) 때문에 connection.getInputStream()으로 읽어들인 문자열이 깨지지 않게 함.
                // BufferReader의 경우 데이터들을 모아 둘 Buffer를 생성함.
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                // StringBuffer의 경우 서버로부터 json형식의 데이터를 스트림으로 받아오는데, 이것을 하나씩 이어붙이기 위한 것임.
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine())!=null){
                    content.append(inputLine);
                }
                in.close();
                System.out.println("content = " + content.toString());
                // {        }
                JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject(); // 객체로 변경해야 핸들링 용이
                JsonObject mainData = weatherData.getAsJsonObject("main");
                double temp = mainData.get("temp").getAsDouble();
                System.out.println("temp = " + temp);

                connection.disconnect();

            }else {
                // 오류
            }

        }catch (Exception e){
            e.printStackTrace(); // 에러메시지 출력
        }

    }
}
