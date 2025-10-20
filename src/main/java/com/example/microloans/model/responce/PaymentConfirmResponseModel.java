package com.example.microloans.model.responce;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class PaymentConfirmResponseModel {
    private String transaction_id;
    private int bank_bik;
    private String status;
    private List<ContactModel> contact;

}

/*
{
"transaction_id": "T-342-67777",
"bank_bik": "2345678997",
"status": "accepted",
"contact" : [
                {
                    "name" : "HL pay company",
                    "telecom" :[
                                    "43t5h7", k8fg534, 67hr333f, gj6iire
                               ]
                }
            ]
}
 */
