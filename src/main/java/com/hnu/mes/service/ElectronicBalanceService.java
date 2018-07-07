package com.hnu.mes.service;

import com.hnu.mes.domain.ElectronicBalance;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.ElectronicBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 16:07 2018/6/30
 * @Modified By:
 */
@Service
public class ElectronicBalanceService {
    @Autowired
    private ElectronicBalanceRepository electronicBalanceRepository;

    public ElectronicBalance save(ElectronicBalance electronicBalance) {
        /**
         * save
         * @Desciption 新增
         * @param [electronicBalance]
         */
        return electronicBalanceRepository.save(electronicBalance);
    }

    public void delete(String code) {
        /**
         * delete
         * @Desciption 删除
         * @param [code]
         */
        electronicBalanceRepository.delete(code);
    }

    public ElectronicBalance findOne(String code) {
        /**
         * findOne
         * @Desciption 查询
         * @param [code]
         */
        return electronicBalanceRepository.findOne(code);
    }

    public List<ElectronicBalance> findAll() {
        /**
         * findAll
         * @Desciption 查找全部
         * @param []
         */
        return electronicBalanceRepository.findAll();
    }

    public Page<ElectronicBalance> getElectronicBalanceByPage(Integer page, Integer size, String sortFieldName, Integer asc) {
        /**
         * getElectronicBalanceByPage
         * @Desciption
         * @param [page, size, sortFieldName, asc]
         * @throws Exception
         */

        try {
            ElectronicBalance.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            throw new MesException(EnumException.SORT_FIELD);
        }

        Sort sort = null;
        if (asc == 0) {
            //降序，desc
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            //升序，asc
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return electronicBalanceRepository.findAll(pageable);
    }

    public Page<ElectronicBalance> findAllByLikeNameByPage(String name, Integer page, Integer size, String sortFieldName, Integer asc) {
        /**
         * findAllByLikeNameByPage
         * @Desciption 通过名称模糊查询
         * @param [name, page, size, sortFieldName, asc]
         */

        try {
            ElectronicBalance.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            throw new MesException(EnumException.SORT_FIELD);
        }

        Sort sort = null;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        // 分页
        Pageable pageable = new PageRequest(page, size, sort);

        // 查询
        return electronicBalanceRepository.findByNameLike("%" + name + "%", pageable);
    }

    public void deleteInBatch(Set<ElectronicBalance> electronicBalancees) {
        electronicBalanceRepository.deleteInBatch(electronicBalancees);
    }
}
