/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.content.Context;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(MockitoJUnitRunner.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    /**
     * Test for negative addition
     */
    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }
    /**
     * Test for addition on floats
     */
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }
    /**
     * Test for subtraction
     */
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(12d, 10d);
        assertThat(resultSub, is(equalTo(2d)));
    }
    /**
     * Test for subtraction with negatives
     */
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(5d, 15d);
        assertThat(resultSub, is(equalTo(-10d)));
    }
    /**
     * Test for multiplication
     */
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(21d, 2d);
        assertThat(resultMul, is(equalTo(42d)));
    }
    /**
     * Test for division
     */
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(66d,2d);
        assertThat(resultDiv, is(equalTo(33d)));
    }
    /**
     * Test for division with zero
     */
    /**
    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(10d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    */
    /**
     * Coding Challenges
     */
    //Challenge 1
    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() throws IllegalArgumentException{
        double resultDiv = mCalculator.div(10d,0d);
        if(resultDiv == Double.POSITIVE_INFINITY){
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
    }
    //Challenge 2
    @Test
    public void calcButton() {
        MainActivity mainActivity = mock(MainActivity.class);
        View mockView = mock(View.class);
        mainActivity.setContentView(mockView);
        mainActivity.onSub(mockView);
        //Then you can do tests with context
    }
}