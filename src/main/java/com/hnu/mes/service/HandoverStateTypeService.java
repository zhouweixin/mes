package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverStateType;
import com.hnu.mes.repository.HandoverStateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:58
 */
@Service
public class HandoverStateTypeService {
    @Autowired
    private HandoverStateTypeRepository handoverStateTypeRepository;

    /**
     * 新增/更新
     * @param handoverStateType
     * @return
     */
    public HandoverStateType save(HandoverStateType handoverStateType){
        if(handoverStateType.getHandoverState1() == null || handoverStateType.getHandoverState1().getCode() == -1)
            handoverStateType.setHandoverState1(null);
        if(handoverStateType.getHandoverState2() == null || handoverStateType.getHandoverState2().getCode() == -1)
            handoverStateType.setHandoverState2(null);
        if(handoverStateType.getHandoverState3() == null || handoverStateType.getHandoverState3().getCode() == -1)
            handoverStateType.setHandoverState3(null);
        if(handoverStateType.getHandoverState4() == null || handoverStateType.getHandoverState4().getCode() == -1)
            handoverStateType.setHandoverState4(null);
        if(handoverStateType.getHandoverState5() == null || handoverStateType.getHandoverState5().getCode() == -1)
            handoverStateType.setHandoverState5(null);
        return handoverStateTypeRepository.save(handoverStateType);
    }

    /**
     * 批量删除
     * @param handoverStateType
     */
    public void deleteInBatch(Collection<HandoverStateType> handoverStateType) {
        handoverStateTypeRepository.deleteInBatch(handoverStateType);
    }

    /**
     * 查询所有
     */
    public List<HandoverStateType> findAll(){
        return handoverStateTypeRepository.findAll();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverStateType> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverStateType.class.getDeclaredField(sortFieldName);
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
        return handoverStateTypeRepository.findAll(pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverStateTypeRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverStateType findByCode(Integer code){
        return handoverStateTypeRepository.findOne(code);
    }

}
