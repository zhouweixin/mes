package com.hnu.mes.service;

import com.hnu.mes.domain.KilnOrder;
import com.hnu.mes.domain.KilnParameter;
import com.hnu.mes.repository.KilnOrderRepository;
import com.hnu.mes.repository.KilnParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 20:29
 */
@Service
public class KilnOrderService {
    @Autowired
    KilnOrderRepository kilnOrderRepository;

    /**
     * 新增
     * @param kilnOrder
     * @return
     */
    public KilnOrder add(KilnOrder kilnOrder){
        return kilnOrderRepository.save(kilnOrder);
    }

    /**
     * 更新
     * @param kilnOrder
     * @return
     */
    public KilnOrder update(KilnOrder kilnOrder){
        kilnOrderRepository.delete(kilnOrder.getCode());
        return kilnOrderRepository.save(kilnOrder);
    }
    /**
     * 批量删除
     * @param kilnOrder
     */
    public void deleteInBatch(Collection<KilnOrder> kilnOrder) {
        kilnOrderRepository.deleteInBatch(kilnOrder);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<KilnOrder> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            KilnOrder.class.getDeclaredField(sortFieldName);
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
        return kilnOrderRepository.findAll(pageable);
    }

    /**
     * 通过窑炉编号模糊查询-分页
     * @param kilnCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<KilnOrder> findByKilnCodeLike(String kilnCode , Integer page , Integer size , String sortFieldName ,
                                                   Integer asc) {
        // 判断排序字段名是否存在
        try {
            KilnOrder.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为kilnCode
            sortFieldName = "kilnCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return kilnOrderRepository.findByKilnCodeLike("%" + kilnCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        kilnOrderRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public KilnOrder findByCode(Integer code){
        KilnOrder kilnOrder = kilnOrderRepository.findOne(code);

        List<KilnParameter> kilnParameters = kilnOrder.getKilnParameters();
        if(kilnParameters != null && kilnParameters.size() > 1){
            for(KilnParameter kilnParameter : kilnParameters){
                kilnParameter.setRank(parseWord(kilnParameter.getTemRange()));
            }
        }

        kilnParameters.sort((o1, o2)->{
            return o1.getRank() - o2.getRank();
        });

        return kilnOrder;
    }

    private static Map<String, Integer> map = new HashMap<String, Integer>();
    static{
        map.put("一", 1);
        map.put("二", 2);
        map.put("三", 3);
        map.put("四", 4);
        map.put("五", 5);
        map.put("六", 6);
        map.put("七", 7);
        map.put("八", 8);
        map.put("九", 9);
        map.put("十", 10);
        map.put("十一", 11);
        map.put("十二", 12);
        map.put("十三", 13);
        map.put("十四", 14);
        map.put("十五", 15);
        map.put("十六", 16);
        map.put("十七", 17);
        map.put("十八", 18);
        map.put("十九", 19);
        map.put("二十", 20);
        map.put("二十一", 21);
        map.put("二十二", 22);
        map.put("二十三", 23);
        map.put("二十四", 24);
        map.put("二十五", 25);
        map.put("二十六", 26);
        map.put("二十七", 27);
        map.put("二十八", 28);
        map.put("二十九", 29);
        map.put("三十", 30);
    }

    /**
     * 中文转数字
     *
     * @param str
     * @return
     */
    private int parseWord(String str){
        if(str ==  null || str.equals("")){
            return 0;
        }

        str = str.replace("区", "");
        return map.getOrDefault(str, 0);
    }


}
