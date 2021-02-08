package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.dto.CreateDebt;
import com.yevhenberladyniuk.debts.repository.DebtRepository;
import com.yevhenberladyniuk.debts.repository.PartnerRepository;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DebtServiceImpl implements DebtService{

    DebtRepository debtRepository;

    PartnerRepository partnerRepository;

    @Autowired
    public DebtServiceImpl(DebtRepository debtRepository, PartnerRepository partnerRepository) {
        this.debtRepository = debtRepository;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<Debt> findAllByPartner(Partner partner) {
        return debtRepository.findAllByPartnerId(partner.getId());
    }

    @Override
    public void create(CreateDebt createDebt, Partner partner) {

        LocalDateTime localDateTime;

        if(createDebt.getTransactionDate() == null){
            localDateTime = LocalDateTime.now();
        }else{
            localDateTime = createDebt.getTransactionDate();
        }

        Debt debt = Debt.builder()
                .partnerId(partner.getId())
                .comment(createDebt.getComment())
                .transactionAmount(createDebt.getTransactionAmount())
                .transactionDate(localDateTime)
                .build();

        debtRepository.save(debt);

        partner.setDebt(partner.getDebt() - createDebt.getTransactionAmount());
        partner.setUpdatedAt(LocalDateTime.now());
        partnerRepository.save(partner);

    }

    @Override
    public void deleteById(Partner partner, Long id) {

        Optional<Debt> optionalDebt = debtRepository.findByIdAndPartnerId(id, partner.getId());
        debtRepository.deleteById(optionalDebt.orElseThrow( () -> new RuntimeException("Debt not found")).getId());

    }
}
