package com.chirag.taskmanager.dto;

import lombok.*;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;


}