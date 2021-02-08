package com.yevhenberladyniuk.debts.repository;

import com.yevhenberladyniuk.debts.domain.Debt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DebtRepository extends CrudRepository<Debt, Long> {

    List<Debt> findAllByPartnerId (Long id);

    Optional<Debt> findByIdAndPartnerId(Long id, Long partnerId);

    void deleteById (Long id);

}
