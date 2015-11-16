package cms.utils;

import java.util.ArrayList;

public class stringToArrayList {
	public static ArrayList<Long> convert(String list, String separator) {
		ArrayList<Long> rList = new ArrayList<Long>();
		if (separator != null && !separator.isEmpty() && list != null
				&& !list.isEmpty()) {
			if (list.contains(separator)) {
				for (String s : list.split(separator)) {
					if (s != null && !s.isEmpty()) {
						rList.add(Long.parseLong(s.trim()));
					}
				}
			} else {
				rList.add(Long.parseLong(list.trim()));
			}
		}else{
			rList= null;
		}
		return rList;
	}
}
