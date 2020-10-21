package com.chat.backcontroll.analysizeinterface;

import com.chat.backcontroll.hiberentity.HiberSearchAnalyze;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysizeCURDRepository extends CrudRepository<HiberSearchAnalyze,Long> {





}
