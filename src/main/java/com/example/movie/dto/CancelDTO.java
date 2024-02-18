package com.example.movie.dto;

import jakarta.persistence.Entity;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelDTO {
    private String merchant_uid;
    private int cancel_request_amount;
    private String reason;
    private PayDTO payDTO;
}
