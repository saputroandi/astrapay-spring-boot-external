package com.astrapay.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteResponseDto {

    private Long id;
    private String title;
    private String content;
}
