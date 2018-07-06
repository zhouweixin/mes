package com.hnu.mes.service;

import com.hnu.mes.domain.*;
import com.hnu.mes.enums.CustomerExceptionEnum;
import com.hnu.mes.exception.CustomerException;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.CustomerDao;
import com.hnu.mes.repository.CustomerRoleRepository;
import com.hnu.mes.repository.DefaultPasswordRepository;
import com.hnu.mes.repository.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanyage on 2018/3/15.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private DefaultPasswordRepository defaultPasswordRepository;
    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private CustomerRoleRepository customerRoleRepository;

    Customer findOne(String code) {
        return customerDao.findOne(code);
    }

    public Page<Customer> findAllPage(int pageNumber, int pageSize, String id, int asc) throws RuntimeException {
        try {
            Supplier.class.getDeclaredField(id);
        } catch (Exception e) {
            throw new CustomerException(CustomerExceptionEnum.SEARCH_ERROR.getMessage());
        }
        Sort sort;
        if (pageSize == 0) {
            sort = new Sort(Sort.Direction.DESC, id);
        } else {
            sort = new Sort(Sort.Direction.ASC, id);
        }
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        return customerDao.findAll(pageable);
    }

    public void update(String codeBefore, Customer one) {
        if (!one.getCode().equals(codeBefore) && customerDao.exists(one.getCode())) {
            throw new CustomerException(CustomerExceptionEnum.PRIMARY_KEY_ERROR.getMessage());
        }
        Customer exist = customerDao.findOne(codeBefore);

        exist.setCode(one.getCode());//设置登录名
        exist.setName(one.getName());//设置用户名称
        exist.setDescription(one.getDescription());//设置描述说明
        exist.setContact(one.getContact());//设置手机号码
        Supplier supplier = supplierDao.findOne(one.getSupplier().getCode());
        exist.setSupplier(supplier);//设置供应商
        customerDao.save(exist);
    }

    @Transactional
    public void add(Customer one) {
        if (customerDao.exists(one.getCode())) {
            throw new CustomerException(CustomerExceptionEnum.PRIMARY_KEY_ERROR.getMessage());
        }
        String password = defaultPasswordRepository.getOne(1).getPassword();
        one.setPassword(password);

        if (one.getSupplier() != null && one.getSupplier().getSupplierType() != null && one.getSupplier().getSupplierType().getCode() == 1) {
            // 供应商
            CustomerRole customerRole = new CustomerRole(one.getCode(), 9);
            customerRoleRepository.save(customerRole);
        } else if (one.getSupplier() != null && one.getSupplier().getSupplierType() != null && one.getSupplier().getSupplierType().getCode() == 2) {
            // 客户
            CustomerRole customerRole = new CustomerRole(one.getCode(), 10);
            customerRoleRepository.save(customerRole);
        }
        customerDao.saveAndFlush(one);
    }

    public void delete(Customer one) {
        customerDao.delete(one);
    }

    public void deleteInBatch(List<Customer> ones) {
        customerDao.deleteInBatch(ones);
    }

    public void resetPassword(String code) {
        Customer exist = findOne(code);
        DefaultPassword defaultPassword = defaultPasswordRepository.findOne(1);
        exist.setPassword(defaultPassword.getPassword());
        update(code, exist);
    }

    public void changePassword(String code, String oldPassword, String newPassword) {
        if (newPassword == null || oldPassword == null ||
                newPassword.trim().equals("") || oldPassword.trim().equals(""))
            throw new CustomerException(CustomerExceptionEnum.PASSWORD_NULL_ERROR.getMessage());
        Customer exist = findOne(code);
        String existPassword = exist.getPassword();
        if (!existPassword.equals(oldPassword))
            throw new CustomerException(CustomerExceptionEnum.WRONG_PASSWORD.getMessage());
        exist.setPassword(newPassword);
        update(code, exist);
    }

    public Customer findByName(String name) {
        return customerDao.findByName(name);
    }

    public Customer login(Customer one) {
        String username = one.getCode();
        String password = one.getPassword();
        Customer exist = findOne(username);
        if (exist == null) {
            throw new CustomerException(CustomerExceptionEnum.USER_NOT_EXISTS_ERROR.getMessage());
        }
        if (!exist.getPassword().equals(password)) {
            throw new CustomerException(CustomerExceptionEnum.WRONG_PASSWORD.getMessage());
        }
        return exist;
    }

    public Customer getByCode(String code) {
        return customerDao.findOne(code);
    }

    @Transactional
    public void updateInBatch(List ones) {
        DefaultPassword defaultPassword = defaultPasswordRepository.findOne(1);
        customerDao.updateInBatch(defaultPassword.getPassword(), ones);
    }

    @Transactional
    public void updateAllDefaultPassword(String defaultPassword) {
        customerDao.updateAllDefaultPassword(defaultPassword);
    }

    public List<Supplier> findByNameLike(String name) {
        return supplierDao.findByNameLike("" + name + "");
    }

    public List<Customer> findBySupplier(Supplier supplier) {
        return customerDao.findBySupplier(supplier);
    }

    /**
     * 通过公司查询-分页
     *
     * @param supplier
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Customer> findBySupplierByPage(Supplier supplier, Integer page, Integer size, String sortFieldName,
                                               Integer asc) {
        try {
            Customer.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 排序的字段名不存在
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

        return customerDao.findBySupplier(supplier, pageable);
    }

    /**
     * 通过公司类型查询用户
     *
     * @param supplierType
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Customer> getBySupplierTypeByPage(SupplierType supplierType, Integer page, Integer size, String sortFieldName, Integer asc) {
        try {
            Customer.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 排序的字段名不存在
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
        List<Supplier> suppliers = supplierDao.findBySupplierType(supplierType);
        return customerDao.findBySupplierIn(suppliers, pageable);
    }
}
