package org.example.model3;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ExcelMember {
    private String name;
    private int age;
    private String birthdate;
    private String phone;
    private String address;
    private boolean isMarried;
}
