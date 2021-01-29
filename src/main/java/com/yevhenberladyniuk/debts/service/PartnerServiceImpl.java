package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.dto.CreatePartnerForm;
import com.yevhenberladyniuk.debts.dto.PartnerDto;
import com.yevhenberladyniuk.debts.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService{

    private PartnerRepository partnerRepository;

    @Autowired
    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public void create(CreatePartnerForm createPartnerForm, Long userId) {

        Partner partner = Partner.builder()
                .userId(userId)
                .firstName(createPartnerForm.getFirstName())
                .lastName(createPartnerForm.getLastName())
                .debt(createPartnerForm.getDebt())
                .date(LocalDateTime.now())
                .build();

        partnerRepository.save(partner);
    }

    @Override
    public List<Partner> findAllByUserId(Long userId) {
        return partnerRepository.findAllByUserId(userId);
    }

    @Override
    public void deletePartnerById(Long id) {
        partnerRepository.deleteById(id);
    }

    @Override
    public Optional<Partner> findPartnerById(Long id) {
        return partnerRepository.findById(id);
    }

    @Override
    public void updatePartnerById(Long id, PartnerDto partnerDto) {

        Optional<Partner> optionalPartner = findPartnerById(id);
        Partner partner = optionalPartner.orElseThrow();
        partner.setLastName(partnerDto.getLastName());
        partner.setFirstName(partnerDto.getFirstName());
        partner.setDate(LocalDateTime.now());
        partnerRepository.save(partner);

    }

}
