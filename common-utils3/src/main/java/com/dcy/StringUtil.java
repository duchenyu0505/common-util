package com.dcy;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class StringUtil {
	/**
	 * @Title: isBlank   
	 * @Description: �ж��ַ����Ƿ�Ϊ��  
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isBlank(String str) {
		if(str==null) {
			return true;
		}
		//ȥ�ո�
		str = str.trim();
		//
		if(str.length()==0) {
			return true;
		}
		return false;
	}
	/**
	 * @Title: isNotBlank   
	 * @Description: �ַ������ݲ�Ϊ�գ�����true   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**
	 * @Title: isPhoneNum   
	 * @Description: �ж��ַ����Ƿ�Ϊ�ֻ���   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	/**
	 * @Title: isEmail   
	 * @Description: ��֤�Ƿ�Ϊ����   
	 * @param: @param str zhanggm1002@qq.com
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isEmail(String str) {
		String regex = "[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * @Title: isLetter   
	 * @Description: TODO(�����������������)   
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isLetter(String str) {
		if(isNotBlank(str)) {
			str = str.toLowerCase();
			String regex = "[a-z]+";
			return str.matches(regex);
		}
		return false;
	}
	/**
	 * @Title: getRandomAzChar   
	 * @Description: ��ȡ����ַ���a-z��   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomAzChar() {
		//�����
		Random random = new Random();
		//��ʼ�ַ���acsii��
		int startChar = 'a'+0;
		//��������ַ�
		char newChar = (char)(startChar+random.nextInt(26));
		return newChar;
	}
	/**
	 * @Title: getRandomLetter   
	 * @Description: ��ȡ����ַ��� 
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomLetter(int num) {
		//�������ɺ��ַ�
		StringBuffer sb = new StringBuffer();
		//��������ַ�
		for(int i=0;i<num;i++) {
			char newChar = getRandomAzChar();
			sb.append(newChar);
		}
		return sb.toString();
	}
	
	/**
	 * @Title: getRandomNumberChar   
	 * @Description: ��ȡ��������ַ� 
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomNumberChar() {
		//�����
		Random random = new Random();
		//��ʼ�ַ���acsii��
		int startChar = '0'+0;
		//��������ַ�
		char newChar = (char)(startChar+random.nextInt(10));
		return newChar;
	}
	/**
	 * @Title: getRandomLetterAndNumberStr   
	 * @Description: �������ַ�����a-z0-9��   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomLetterAndNumberStr(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			if(random.nextInt(36)>10) {
				sb.append(getRandomAzChar());
			}else {
				sb.append(getRandomNumberChar());
			}
		}
		return sb.toString();
	}
	
	/**
	 * @Title: randomChineseString   
	 * @Description: ����һ����������//GB2312���ļ���  
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: ���ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ��   
	 * @param: @param length
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomChineseString();
		}

		return str;
	}
	/**
	 * @Title: randomChineseName   
	 * @Description: ����������������������ʵ�տ�ͷ
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseName() {
		String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
				"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
				"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
				"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
				"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
				"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
				"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
				"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
				"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
				"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
				"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
				"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
				"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
				"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
				"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
				"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
				"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
				"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
		// �����ȡ����
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// �����ȡ1-2������
		String name2 = randomChineseString(RandomUtil.random(1, 2));
		return name1 + name2;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(randomChineseName());
		}
	}
	
	
}