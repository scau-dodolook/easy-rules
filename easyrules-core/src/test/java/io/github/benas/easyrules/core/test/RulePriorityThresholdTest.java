/*
 * The MIT License
 *
 *  Copyright (c) 2014, Mahmoud Ben Hassine (md.benhassine@gmail.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package io.github.benas.easyrules.core.test;

import io.github.benas.easyrules.api.RulesEngine;
import io.github.benas.easyrules.core.PriorityRulesEngine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class of "Rule Priority Threshold" parameter of Easy Rules engine.
 *
 * @author Mahmoud Ben Hassine (md.benhassine@gmail.com)
 */
public class RulePriorityThresholdTest {

    private SimplePriorityRule rule1, rule2;

    private RulesEngine rulesEngine;

    @Before
    public void setup(){

        rule1 = new SimplePriorityRule("r1","d1",1);
        rule2 = new SimplePriorityRule("r2","d2",2);

        rulesEngine = new PriorityRulesEngine(1);
    }

    @Test
    public void testRulePriorityThreshold() {

        rulesEngine.registerRule(rule1);
        rulesEngine.registerRule(rule2);

        rulesEngine.fireRules();

        //Rule 1 should be executed
        assertEquals(true, rule1.isExecuted());

        //Rule 2 should be skipped since its priority (2) exceeds priority threshold (1)
        assertEquals(false, rule2.isExecuted());

    }

}
