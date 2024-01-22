package com.imcjava.dto.qualificationDto;

import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QualificationRequest {
    private String qualification;
    private String experience;
    private User user;
}

//we can pass payload from postman like this
//    {
//        "qualification":"Bs computer science",
//        "7 years of experience",
//        "user:{
//              "id":"hjjgh33434jh3j4hj34j"
//              }
//        }