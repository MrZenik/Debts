package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreateDebt;
import com.yevhenberladyniuk.debts.dto.DebtDto;

import java.util.List;

public interface DebtService {

    List<Debt> findAllByPartner(Long partnerId, User user);

    void create(CreateDebt createDebt, Long partnerId, User user);

    void deleteById(Long partnerId, Long id, User user);

    void updateById(Long id, DebtDto debtDto, Long partnerId, User user);

    Debt findByIdAndPartnerId(Long id, Long partnerId, User user);
}
