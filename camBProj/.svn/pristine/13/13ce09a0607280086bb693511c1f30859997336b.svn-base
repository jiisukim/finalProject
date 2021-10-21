package kr.or.ddit.util.format.service;

import org.springframework.stereotype.Service;

/**
 * DB에 저장된 값을 화면에 표시할 때 사용 
 * ex. 휴대폰 번호를 형식에 맞게 출력
 *     01012341234 -> 010-1234-1234
 * @author PC-08
 *
 */
@Service
public class FormatUtil {
		 
	public String phone(String src) {
		if (src == null) {
			return "";
		}
		if (src.length() == 8) {
			return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
		} else if (src.length() == 12) {
			return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
		}
		return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	}

}
