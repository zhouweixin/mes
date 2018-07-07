package com.hnu.mes.repository;

import com.hnu.mes.domain.ByproductCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 9:06
 */
public interface ByproductCountRepository extends JpaRepository<ByproductCount,Integer> {
    /**
     * 通过生产批号模糊查询
     * @param batchNumber
     * @param pageable
     * @return
     */
    public Page<ByproductCount> findByBatchNumberLike(String batchNumber, Pageable pageable);

    /**
     * 通过副产品类型搜索
     * @param byproductCode
     * @param pageable
     * @return
     */
    public Page<ByproductCount> findByByproductCode_Code(Integer byproductCode, Pageable pageable);

    /**
     * 通过副产品类型和生产年月查询
     * @param year
     * @param month
     * @return
     */
    @Query(value = "select * from  release_byproduct_count where byproduct_code=?1 and year(date)=?2 and MONTH(date)=?3 ORDER BY date ASC", nativeQuery = true)
    public List<ByproductCount> findByByproductCodeAndYearAndMonth(Integer byproductCode, Integer year, Integer month);
}
