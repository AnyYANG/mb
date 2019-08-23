package cn.liuyangjob.service;

import cn.liuyangjob.bean.PlatformActivitiesJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  liuyang
 * 2019/8/22    17:27
 * cn.liuyangjob.service
 * All Right Reserved by liuyang.
 **/
@Repository
public interface JoinService extends JpaRepository<PlatformActivitiesJoin, Long>, JpaSpecificationExecutor<PlatformActivitiesJoin> {
    public List<PlatformActivitiesJoin> getPlatformActivitiesJoinByPlatformActivitiesId(Long PlatformActivitiesId);

}
