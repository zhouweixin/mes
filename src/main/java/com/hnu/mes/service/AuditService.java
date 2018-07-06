package com.hnu.mes.service;

import com.hnu.mes.domain.Audit;
import com.hnu.mes.domain.ElectronicBalance;
import com.hnu.mes.domain.Equipment;
import com.hnu.mes.repository.AuditRepository;
import com.hnu.mes.repository.ElectronicBalanceRepository;
import com.hnu.mes.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/29 14:29
 */
@Service
public class AuditService {
    @Autowired
    private AuditRepository auditRepository;

    /**
     * 新增
     * @param audit
     * @return
     */
    public Audit add(Audit audit){
        Date currentTime = new Date();
        audit.setAuditTime(currentTime);
        return auditRepository.save(audit);
    }

    /**
     * 更新——确认
     * @param audit
     * @return
     */
    public Audit update(Audit audit){
        Date currentTime = new Date();
        if(audit.getConfirm() == 1){
            audit.setConfirmTime(currentTime);
        }
        audit.setAuditTime(auditRepository.findOne(audit.getCode()).getAuditTime());
        return auditRepository.save(audit);
    }


    /**
     * 批量删除
     * @param audit
     */
    public void deleteInBatch(Collection<Audit> audit) {
        auditRepository.deleteInBatch(audit);
    }

    /**
     * 查询所有
     */
    public List<Audit> findAll(){
        return auditRepository.findAll();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Audit> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            Audit.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为code
            sortFieldName = "code";
        }
        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return auditRepository.findAll(pageable);
    }

    /**
     * 通过电子秤编号查询-分页
     * @param equipmentCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Audit> findByEquipmentCodeByPage(Integer equipmentCode , Integer page , Integer size , String sortFieldName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            Audit.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为code
            sortFieldName = "code";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);

        return auditRepository.findByEquipmentCode_Code(equipmentCode, pageable);
    }

    /**
     * 通过电子秤编号和确认状态查询
     * @param equipmentCode
     * @param confirm
     * @return
     */
    public List<Audit> findByEquipmentCodeAndConfirm(Integer equipmentCode,Integer confirm){
        return auditRepository.findByEquipmentCode_CodeAndConfirm(equipmentCode,confirm);
    }

    /**
     * 通过确认状态查询-分页
     * @param confirm
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Audit> findByConfirm(Integer confirm , Integer page , Integer size , String sortFieldName ,
                                                 Integer asc) {
        // 判断排序字段名是否存在
        try {
            Audit.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为code
            sortFieldName = "code";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);

        return auditRepository.findByConfirm(confirm, pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        auditRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public Audit findByCode(Integer code){
        return auditRepository.findOne(code);
    }

}
