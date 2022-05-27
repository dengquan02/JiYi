package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.dao.CheckTotalDao;
import com.ghz.diagnosis.entity.CheckTotal;
import com.ghz.diagnosis.service.CheckTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CheckTotal)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 19:49:21
 */
@Service("checkTotalService")
public class CheckTotalServiceImpl implements CheckTotalService {
    @Resource
    private CheckTotalDao checkTotalDao;

    @Override
    public List<CheckTotal> query() {
        return this.checkTotalDao.query();
    }

    @Override
    public int insert(CheckTotal checkTotal) {
        return this.checkTotalDao.insert(checkTotal);
    }

    @Override
    public boolean deleteById(String checkName) {
        return this.checkTotalDao.deleteById(checkName) > 0;
    }
}
