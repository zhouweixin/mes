package com.hnu.mes.repository;

import com.hnu.mes.domain.SupplierType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by lanyage on 2018/3/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierTypeDaoTest {

    @Autowired
    private SupplierTypeDao supplierTypeDao;

    @Test
    public void testFindOne() {
       SupplierType supplierType = supplierTypeDao.findByCode(1);
    }
}