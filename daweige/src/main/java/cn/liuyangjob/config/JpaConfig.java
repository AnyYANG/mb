package cn.liuyangjob.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Order(Ordered.HIGHEST_PRECEDENCE)//定义组件的加载顺序，这里为最高级
@Configuration//表明这是一个配置类
@EnableTransactionManagement(proxyTargetClass = true)//启用JPA的事物管理
@EnableJpaRepositories(basePackages = "cn.liuyangjob")//启动JPA资源库并设置接口资源库的位置
@EntityScan(basePackages = "cn.liuyangjob.bean")//实体类位置
public class JpaConfig {

    /**
     * @return
     */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
