/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.echo2craft.mathutil.core;

import static com.echo2craft.mathutil.core.MathUtil.*;
import org.junit.jupiter.api.function.Executable;
//import static la danh rieng cho nhung ham static
//goi ham ma bo qua ten class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author PC
 */
public class MathUtilTest {

    //choi DataDrivenTesting, tach data ra khoi cau lenh kiem thu, tham so hoa data nay
    //vao trong cau lenh kiem thu
    //chuan bi bo data
    public static Object[][] initData(){
        return new Integer[][]{
            {0,1},
            {1,1},
            {2,2},
            {5,120},
            {6,720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData")// ten ham cung cap data, ngam dinh thu tu cua cac phan tu cua mang
    //,map vao tham so ham
    public void testGetFactorialGivenRightArgumentReturnWell(int input,long expected) {
        assertEquals(expected,getFactorial(input));
    }
    //Bat ngoai le khi dua data ca chon!!!
    //@Test (expected = ten ngoai le.class) JUnit hoy, JUnit hok xai vay!!!
    @Test
    public void testGetFactorialGivenWrongArgThrowException(){
        //Bieu thuc lambda
        //Ham nhan tham so thu 2 la 1 cai object/ co code implement cai
        //functional interface ten la Executable - co 1 ham duy nhat ko code
        //ten la execute()
        //choi cham
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);            
//            }
//        };
//        Executable exObject = () -> 
//            getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> 
            getFactorial(-5));
    }
}
