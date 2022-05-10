package com.ghz.diagnosis.core;

/**
 * @author: Gu HungJou
 * @date: 2021/11/25 13:01
 * Describe:
 */
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import java.io.Serializable;

/**
 * 自定义ID生成器
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-08 15:42
 */
public class recordIDGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        Object id =  SnowFlakeUtil.getId();
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}
