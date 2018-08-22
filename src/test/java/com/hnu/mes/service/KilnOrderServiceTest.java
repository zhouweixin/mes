package com.hnu.mes.service;

import com.hnu.mes.MesApplication;
import com.hnu.mes.domain.KilnOrder;
import com.hnu.mes.domain.KilnParameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 9:13 2018/8/22
 * @Modified By:
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MesApplication.class)
@WebAppConfiguration
public class KilnOrderServiceTest {

    @Autowired
    private KilnOrderService kilnOrderService;

    @Test
    public void findByCode() {
        KilnOrder kilnOrder = kilnOrderService.findByCode(39);
        for(KilnParameter kilnParameter : kilnOrder.getKilnParameters()){
            System.out.println(kilnParameter.getTemRange());
        }
    }
}