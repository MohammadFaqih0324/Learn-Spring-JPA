package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.AddressSaveRequest;
import lombok.Data;

@Data
public class AddressUpdateRequest extends AddressSaveRequest {
    private Long id;
    private String updateBy;
}
