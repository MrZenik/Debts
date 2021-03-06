package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreateDebtForm;
import com.yevhenberladyniuk.debts.dto.DebtDto;
import com.yevhenberladyniuk.debts.repository.DebtRepository;
import com.yevhenberladyniuk.debts.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DebtServiceImpl implements DebtService{

    private DebtRepository debtRepository;

    private PartnerRepository partnerRepository;

    private  PartnerService partnerService;

    @Autowired
    public DebtServiceImpl(DebtRepository debtRepository, PartnerRepository partnerRepository, PartnerService partnerService) {
        this.debtRepository = debtRepository;
        this.partnerRepository = partnerRepository;
        this.partnerService = partnerService;
    }

    @Override
    public List<Debt> findAllByPartnerId(Long partnerId, User user) {
        checkAccessToPartner(partnerId, user);
        return debtRepository.findAllByPartnerIdOrderByTransactionDateDesc(partnerId);
    }

    @Override
    @Transactional
    public void create(CreateDebtForm createDebt, User user) {

        Partner partner = checkAccessToPartner(createDebt.getPartnerId(), user);
        LocalDateTime transactionDate = createDebt.getTransactionDate() == null ?
                                                            LocalDateTime.now() : createDebt.getTransactionDate() ;

        Debt debt = Debt.builder()
                .partnerId(createDebt.getPartnerId())
                .comment(createDebt.getComment())
                .transactionAmount(createDebt.getTransactionAmount())
                .transactionDate(transactionDate)
                .build();

        debtRepository.save(debt);

        partner.setDebt(partner.getDebt() + createDebt.getTransactionAmount());
        partner.setUpdatedAt(LocalDateTime.now());
        partnerRepository.save(partner);

    }

    @Override
    public void deleteById(Long partnerId, Long id, User user) {

        Partner partner = checkAccessToPartner(partnerId, user);
        Debt debt = findByIdAndPartnerId(id, partner.getId(), user);
        debtRepository.deleteById(debt.getId());

    }

    @Override
    public void updateById(Long id, DebtDto debtDto, Long partnerId, User user) {

        checkAccessToPartner(partnerId, user);

        Debt debt = findByIdAndPartnerId(id, partnerId, user);

        LocalDateTime transactionDate = debtDto.getTransactionDate() == null ?
                                                        LocalDateTime.now() : debtDto.getTransactionDate() ;
        debt.setComment(debtDto.getComment());
        debt.setTransactionDate(transactionDate);

        debtRepository.save(debt);
    }

    @Override
    public Debt findByIdAndPartnerId(Long id, Long partnerId, User user){
        checkAccessToPartner(partnerId, user);
        return debtRepository.findByIdAndPartnerId(id, partnerId).orElseThrow(
                            () -> new RuntimeException("Debt not found"));
    }

    private Partner checkAccessToPartner(Long partnerId, User user){
        return partnerService.findById(partnerId, user);
    }
}
