package com.dcy;

import java.util.Random;

/**
 * ���������
 * @Description:TODO(��������������)   
 * @author: zhanggm1002
 * @date:   2019��12��5�� ����1:31:23
 */
public class RandomUtil {
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��������   
	 * @param: @param min
	 * @param: @param max
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��Ķ�������
	 * @param: @param min
	 * @param: @param max
	 * @param: @param num
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
}