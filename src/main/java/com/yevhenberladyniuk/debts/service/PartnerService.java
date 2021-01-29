package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.dto.CreatePartnerForm;
import com.yevhenberladyniuk.debts.dto.PartnerDto;

import java.util.List;
import java.util.Optional;

public interface PartnerService {

    void create(CreatePartnerForm createPartnerForm, Long userId);

    List<Partner> findAllByUserId(Long userId);

    void deletePartnerById(Long id);

    Optional<Partner> findPartnerById(Long id);

    void updatePartnerById(Long id, PartnerDto partnerDto);
}
