package com.tn.Req;

import lombok.Data;

import java.util.List;
@Data
public class Userreq {
    private Integer accountId;

    private List<Integer> roleIds;
}
