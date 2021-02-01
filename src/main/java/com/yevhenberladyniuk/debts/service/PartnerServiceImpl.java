package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
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
    public void create(CreatePartnerForm createPartnerForm, User user) {

        Partner partner = Partner.builder()
                .userId(user.getId())
                .firstName(createPartnerForm.getFirstName())
                .lastName(createPartnerForm.getLastName())
                .debt(createPartnerForm.getDebt())
                .updatedAt(LocalDateTime.now())
                .active(true)
                .build();

        partnerRepository.save(partner);
    }

    @Override
    public List<Partner> findAll(User user) {
        return partnerRepository.findAllByUserIdAndActive(user.getId(), true);
    }

    @Override
    public void deleteById(Long id, User user) {
        Partner partner = findById(id, user);
        partner.setActive(false);
        partnerRepository.save(partner);
    }

    @Override
    public Partner findById(Long id, User user) {

        Optional<Partner> optionalPartner = partnerRepository.findByIdAndActiveAndUserId (id, true, user.getId());
        return optionalPartner.orElseThrow( () -> new RuntimeException("Partner not found"));
    }

    @Override
    public void updateById(Long id, PartnerDto partnerDto, User user) {

        Partner partner = findById(id, user);
        partner.setLastName(partnerDto.getLastName());
        partner.setFirstName(partnerDto.getFirstName());
        partner.setUpdatedAt(LocalDateTime.now());
        partnerRepository.save(partner);

    }

}
