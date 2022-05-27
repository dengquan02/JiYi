package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.dao.SymptomTotalDao;
import com.ghz.diagnosis.entity.SymptomTotal;
import com.ghz.diagnosis.service.SymptomTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SymptomTotal)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 19:52:14
 */
@Service("symptomTotalService")
public class SymptomTotalServiceImpl implements SymptomTotalService {
    @Resource
    private SymptomTotalDao symptomTotalDao;

    @Override
    public List<SymptomTotal> query() {
        return this.symptomTotalDao.query();
    }

    @Override
    public int insert(SymptomTotal symptomTotal) {
        return this.symptomTotalDao.insert(symptomTotal);
    }

    @Override
    public boolean deleteById(String symptomName) {
        return this.symptomTotalDao.deleteById(symptomName) > 0;
    }
}
