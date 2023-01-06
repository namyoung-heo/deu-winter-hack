package com.example.dto;

import com.example.entity.AddressEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressDto {
    private Long addressId;
    private String address;

    @Builder
    public AddressDto(Long addressId, String address) {
        this.addressId = addressId;
        this.address = address;
    }

    public AddressEntity toEntity() {
        return AddressEntity.builder().addressId(addressId).address(address).build();
    }
}
