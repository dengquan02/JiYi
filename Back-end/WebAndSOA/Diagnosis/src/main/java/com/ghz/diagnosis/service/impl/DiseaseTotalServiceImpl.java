package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.dao.DiseaseTotalDao;
import com.ghz.diagnosis.entity.DiseaseTotal;
import com.ghz.diagnosis.service.DiseaseTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DiseaseTotal)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 19:51:28
 */
@Service("diseaseTotalService")
public class DiseaseTotalServiceImpl implements DiseaseTotalService {
    @Resource
    private DiseaseTotalDao diseaseTotalDao;


    @Override
    public List<DiseaseTotal> query() {
        return this.diseaseTotalDao.query();
    }

    @Override
    public int insert(DiseaseTotal diseaseTotal) {
        return this.diseaseTotalDao.insert(diseaseTotal);
    }

    @Override
    public boolean deleteById(String diseaseName) {
        return this.diseaseTotalDao.deleteById(diseaseName) > 0;
    }
}
