package com.example.hb.repository;

import com.example.entity.LotteryHistory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("LotteryHistoryRepository")
public interface LotteryHistoryRepository extends CrudRepository<LotteryHistory, Long> {
}
