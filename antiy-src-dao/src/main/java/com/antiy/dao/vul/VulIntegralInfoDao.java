package com.antiy.dao.vul;


import com.antiy.entity.vul.VulIntegralInfo;
import com.antiy.response.vul.ScoreTop10;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface VulIntegralInfoDao {

    void saveSingle(VulIntegralInfo vulIntegralInfo);

    List<VulIntegralInfo> getScoreOfUser(long userId);

    List<ScoreTop10> getPersonalTop10(@Param("start") Long start, @Param("end") Long end);

    List<ScoreTop10> getDepartmentTop10(@Param("start") Long start, @Param("end") Long end);
}
