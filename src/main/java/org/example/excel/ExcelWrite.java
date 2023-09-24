package org.example.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Main;
import org.example.model3.ExcelMember;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ExcelMember> members = new ArrayList<>();

        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = scanner.nextLine();
            if (name.equals("quit")){
                break;
            }

            System.out.print("나이를 입력하세요 : ");
            int age = scanner.nextInt();
            scanner.nextLine(); // 개행문자 제거

            System.out.print("생년월일을 입력하세요");
            String birthday = scanner.nextLine();

            System.out.print("전화번호를 입력하세요");
            String phone = scanner.nextLine();

            System.out.print("주소를 입력하세요");
            String address = scanner.nextLine();

            System.out.print("결혼여부를 입력하세요");
            boolean isMarried = scanner.nextBoolean();
            scanner.nextLine(); // 개행문자 제거

            ExcelMember member = new ExcelMember(name, age, birthday, phone, address, isMarried);
            members.add(member);
        }

        scanner.close();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("회원정보");

            // 헤더 생성
            Row headerrRow = sheet.createRow(0);
            headerrRow.createCell(0).setCellValue("이름");
            headerrRow.createCell(1).setCellValue("나이");
            headerrRow.createCell(2).setCellValue("생년월일");
            headerrRow.createCell(3).setCellValue("전화번호");
            headerrRow.createCell(4).setCellValue("주소");
            headerrRow.createCell(5).setCellValue("결혼여부");

            // 데이터 생성
            for ( int i = 0; i<members.size(); i++){
                ExcelMember member = members.get(i);
                Row row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(member.getName());
                row.createCell(1).setCellValue(member.getAge());
                row.createCell(2).setCellValue(member.getBirthdate());
                row.createCell(3).setCellValue(member.getPhone());
                row.createCell(4).setCellValue(member.getAddress());
                row.createCell(5).setCellValue(member.isMarried());
            }
            // 엑셀 파일 저장
            String fileName = "members.xlsx";
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            workbook.write(outputStream);
            workbook.close();;
            System.out.println("엑셀파일이 저장되었습니다." + fileName);

        }catch (IOException e){
            System.out.println("엑셀 파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
