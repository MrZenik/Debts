package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.dto.CreateDebt;

import java.util.List;

public interface DebtService {

    List<Debt> findAllByPartner(Partner partner);

    void create(CreateDebt createDebt, Partner partner);

    void deleteById(Partner partner, Long id);
}
