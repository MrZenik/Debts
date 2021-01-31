package com.yevhenberladyniuk.debts.repository;

import com.yevhenberladyniuk.debts.domain.Partner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends CrudRepository<Partner, Long> {

    Optional<Partner> findByIdAndActive(Long id, boolean active);

    List<Partner> findAllByUserIdAndActive(Long userId, boolean active);

}
