package com.heima.java;

import org.junit.jupiter.api.Test;

/**
 * @ClassName: SwitchTest
 * @Description:
 * @Author: LXY
 * @Data: 2024/4/17 21:37
 */
public class SwitchTest {

    @Test
    void switchTest(){
        int num = 2;
        switch (num){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("null");
                break;
        }
    }
    @Test
    void switchWithJDK12Test(){
        int num = 2;
        switch (num){
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            default -> System.out.println("null");
        }
    }



    public static void main(String[] args) {

    }
}
