package com.example.hb.repository;

import com.example.entity.LotteryStandard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("LotteryStandardRepository")
public interface LotteryStandardRepository extends CrudRepository<Long, LotteryStandard> {
}
