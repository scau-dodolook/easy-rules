package io.github.benas.easyrules.core.test;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for Easy Rules core module.
 *
 * @author Mahmoud Ben Hassine (md.benhassine@gmail.com)
 */

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        RulePriorityComparisonTest.class,
        RulePriorityThresholdTest.class,
        SkipOnFirstAppliedRuleTest.class,
        JmxRuleRegistrationTest.class,
        CompositeRuleTest.class,
        CompositePriorityRuleTest.class})
public class EasyRulesTestSuite extends TestSuite {

}
