package com.example.movie.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CancelDTO {
    private String merchant_uid;
    private int cancel_request_amount;
    private String reason;
    private PayDTO payDTO;
}
