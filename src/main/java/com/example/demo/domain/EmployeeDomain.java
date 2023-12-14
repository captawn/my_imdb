package com.example.demo.domain;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDomain {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
