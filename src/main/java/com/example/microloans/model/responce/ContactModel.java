package com.example.microloans.model.responce;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ContactModel {

    private String name;
    List<String> telecom;
}
/*
"contact" : [
                {
                    "name" : "HL pay company",
                    "telecom" :[
                                    "43t5h7", k8fg534, 67hr333f, gj6iire
                               ]
                }
            ]
 */
