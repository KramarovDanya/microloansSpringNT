package com.example.microloans.model.request;

import lombok.*;

/*
{
"transaction_id": "T-342-67777",
"sum": 133.12,
"need_processing": true
}
 */
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentConfirmRequestModel {
    private String transaction_id;
    private float payment_id;
    private boolean need_processing;
}
