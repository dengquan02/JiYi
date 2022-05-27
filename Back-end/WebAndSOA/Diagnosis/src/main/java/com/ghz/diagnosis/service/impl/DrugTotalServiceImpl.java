package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.dao.DrugTotalDao;
import com.ghz.diagnosis.entity.DrugTotal;
import com.ghz.diagnosis.service.DrugTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DrugTotal)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 19:51:51
 */
@Service("drugTotalService")
public class DrugTotalServiceImpl implements DrugTotalService {
    @Resource
    private DrugTotalDao drugTotalDao;


    @Override
    public List<DrugTotal> query() {
        return this.drugTotalDao.query();
    }

    @Override
    public int insert(DrugTotal drugTotal) {
        return this.drugTotalDao.insert(drugTotal);
    }

    @Override
    public boolean deleteById(String drugName) {
        return this.drugTotalDao.deleteById(drugName) > 0;
    }
}
