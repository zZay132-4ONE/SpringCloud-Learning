package com.github.zzay.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzay
 * @className MyRule
 * @description Customize the rule of Ribbon's service selection
 * @create 2022/04/29 13:42
 */
@Configuration
public class MyRule {

    /**
     * Customize the rule of Ribbon's service selection
     *
     * @return The rule of Ribbon's service selection
     */
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }

}
