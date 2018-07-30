package hello.repository;

import hello.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serg on 2018-07-25.
 */
@Repository
public class RuleRepositoryImpl implements RuleRepository {
    @Autowired
    SimpleJdbcInsertOperations jdbcDriver;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer save(Rule rule) {
        Integer newRuleId = createRuleRecord(rule);
        creteRuleMonitorTable(newRuleId);

        return newRuleId;
    }

    private Integer createRuleRecord(Rule rule){
        Map<String, Integer> sqlInsert = new HashMap<>();
        sqlInsert.put("start_event_id", 1);
        KeyHolder keyHolder = jdbcDriver.executeAndReturnKeyHolder(sqlInsert);
        Integer newRuleId = keyHolder.getKey().intValue();

        return newRuleId;
    }

    private void creteRuleMonitorTable(Integer ruleId){
        final String CREATE_RULE_MONITOR_TEMPLATE = "";
    }
}
