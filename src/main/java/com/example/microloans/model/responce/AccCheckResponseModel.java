package com.example.microloans.model.responce;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class AccCheckResponseModel {

    private String account;

    @JsonProperty("vip-client")
    private boolean vip_client;
    private boolean blocked;
    private String inn;
    private List<DeptModel> dept;


}
