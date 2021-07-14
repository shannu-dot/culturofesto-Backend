package com.CulturoFesto.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public String GenerateUid(String FName, String Lname) {

		/*
		 * First name - Harshith User-Hars3421 3421-Random 4 digit number generated
		 */

		String result = "";
		char arr[] = FName.toCharArray();
		for (int i = 0; i < 4; i++) {
			result += arr[i];
		}
		result += (int) (Math.random() * 10000);
		return result;
	}

	/*
	 * Password Generation fname-Harshith lname-Oberoi,mobile number-9815492283,dob
	 * 1997-26-09 (Last character of First name)+(first character of last name) +
	 * (odd place digits of mobile)+(sum of year) +(random alphabet)+(random number)
	 * hO914288A1
	 */
	public String GeneratePassword(String FName, String Lname, String Mobile, String dob) {
		String passwordResult = "";
		String mobile = "";
		char arr[] = ("" + Mobile).toCharArray();
		for (int i = 0; i < 9; i += 2) {
			mobile += arr[i];
		}
		int sum = 0;
		String[] dateParts = dob.split("-");
		String year = dateParts[2];
		char ch[] = year.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			sum += (ch[j] - '0');
		}

		int temp = sum;
		int rem = 0;
		while (temp > 0 || rem > 9) {
			if (temp == 0) {
				temp = rem;
				rem = 0;
			}
			rem += temp % 10;
			temp /= 10;
		}
		int length = FName.length();
		String RandomAlphaNumeric = (((char) (Math.random() * 10 + 65)) + "" + ((int) Math.random() * 10));
		passwordResult += (FName.charAt(length - 1)) + "" + (Lname.charAt(0)) + "" + (String) mobile + "" + rem + ""
				+ RandomAlphaNumeric;
		return passwordResult;
	}
}