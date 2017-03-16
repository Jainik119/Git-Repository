package com.adit.util;

import java.util.zip.DataFormatException;

public class DataParser {

	public static String getMaskedPhoneNumberString(String message, String replace, String number, int last) {
		StringBuilder ret = new StringBuilder();
		int length = number.length();
		for (int i = 1; i <= length - last; i++) {
			ret.append("*");
		}
		ret.append(number.substring(length - last));
		return message.replace(replace, ret.toString());
	}

	public static Long getNullableId(String id) throws DataFormatException {
		Long lId = null;
		try {
			if (id != null) {
				lId = Long.valueOf(id);
			}
		} catch (Exception e) {

			throw new DataFormatException(id);
		}
		return lId;
	}

	public String getDoubleStringValue(Double obj) {
		String objString = "0.00";
		if (obj != null) {
			objString = String.format("%.2f", obj);
		}
		return objString;
	}

	public Double getDoubleValue(String val) throws DataFormatException {
		Double lId;
		try {
			lId = Double.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public String getIntegerStringValue(Integer obj) {
		String objString = "0";
		if (obj != null) {
			objString = obj.toString();
		}
		return objString;
	}

	public Integer getIntegerValue(String val) throws DataFormatException {
		Integer lId;
		try {
			lId = Integer.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public String getLongStringValue(Long obj) {
		String objString = "0";
		if (obj != null) {
			objString = obj.toString();
		}
		return objString;
	}

	public Long getLongValue(String val) throws DataFormatException {
		Long lId;
		try {
			lId = Long.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public Double getNullableDoubleValue(String val) throws DataFormatException {
		Double lId = 0.0;
		try {
			if (val != null && val.trim().length() > 0)
				lId = Double.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}
		return lId;
	}

	public Integer getNullableIntegerValue(String val) throws DataFormatException {
		Integer lId = 0;
		try {
			if (val != null && val.trim().length() > 0)
				lId = Integer.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public Long getNullableLongValue(String val) throws DataFormatException {
		Long lId = 0L;
		try {
			if (val != null && val.trim().length() > 0)
				lId = Long.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public Short getNullableShortValue(String val) throws DataFormatException {
		Short lId = 0;
		try {
			if (val != null && val.trim().length() > 0)
				lId = Short.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public String getObjectStringValue(Object obj) {
		String objString = "";
		if (obj != null) {
			objString = obj.toString();
		}
		return objString;
	}

	public String getShortStringValue(Short obj) {
		String objString = "0";
		if (obj != null) {
			objString = obj.toString();
		}
		return objString;
	}

	public Short getShortValue(String val) throws DataFormatException {
		Short lId;
		try {
			lId = Short.valueOf(val);
		} catch (Exception e) {
			throw new DataFormatException(val);
		}

		return lId;
	}

	public String getStringValue(String obj) {
		String objString = "";
		if (obj != null) {
			objString = obj;
		}
		return objString;
	}

	public Long validateId(String id) throws DataFormatException {
		Long lId;
		try {
			lId = Long.valueOf(id);
		} catch (Exception e) {
			throw new DataFormatException(id);
		}

		return lId;
	}

}
