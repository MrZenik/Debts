package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreatePartnerForm;
import com.yevhenberladyniuk.debts.dto.PartnerDto;

import java.util.List;

public interface PartnerService {

    void create(CreatePartnerForm createPartnerForm, User user);

    List<Partner> findAll(User user);

    void deletePartnerById(Long id, User user);

    Partner findPartnerById(Long id, User user);

    void updatePartnerById(Long id, PartnerDto partnerDto, User user);
}
