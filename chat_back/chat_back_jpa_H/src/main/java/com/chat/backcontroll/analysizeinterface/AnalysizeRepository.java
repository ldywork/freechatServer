package com.chat.backcontroll.analysizeinterface;

import com.chat.backcontroll.hiberentity.HiberSearchAnalyze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysizeRepository extends JpaRepository<HiberSearchAnalyze,Long>  {

    List<HiberSearchAnalyze> findByKeyWord(String keyWord);
    List<HiberSearchAnalyze> findByKeyWordLike(String keyWord);
    List<HiberSearchAnalyze> findByMeansContaining(String keyWord);

    @Query("select a from HiberSearchAnalyze a where id = ?1")
    List<HiberSearchAnalyze> findBySql(Long id);

    @Query("select a from HiberSearchAnalyze a where keyWord like :name")
    List<HiberSearchAnalyze> findBySqlUseKey(@Param("name") String key);
    @Query("select a from HiberSearchAnalyze a where key_word like :name")
    List<HiberSearchAnalyze> findBySqlUseKey2(@Param("name") String key);

    @Query(value = "select * from chat_search_analyze  where key_word like :name",nativeQuery = true)
    List<HiberSearchAnalyze> findBySqlUseKeyNative(@Param("name") String key);



}
