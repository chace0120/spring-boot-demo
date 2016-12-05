package cn.chace.www.springboot.mybatis.web;

import cn.chace.www.springboot.mybatis.enums.DayOfWeek;
import cn.chace.www.springboot.mybatis.model.RuleDetail;
import cn.chace.www.springboot.mybatis.repository.RuleDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

/**
 * @author chenx
 * @date 2016/3/30
 */
@RestController
public class RuleController {
    @Autowired
    private RuleDetailMapper ruleDetailMapper;

    @RequestMapping("/rules")
    public List<RuleDetail> getAll() {
        return ruleDetailMapper.selectAll();
    }

    @RequestMapping("/rules/add")
    public String addRule() {
        RuleDetail ruleDetail = new RuleDetail();
        ruleDetail.setDayOfWeek(DayOfWeek.Mon);
        ruleDetail.setRuleId(20);
        ruleDetail.setStartTime(new Time(System.currentTimeMillis()));
        ruleDetail.setEndTime(new Time(System.currentTimeMillis()));

        int result = ruleDetailMapper.insert(ruleDetail);

        return "新增结果：" + result;
    }
}
