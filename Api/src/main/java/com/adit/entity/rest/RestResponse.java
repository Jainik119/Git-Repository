package com.adit.entity.rest;

public class RestResponse {

	private Object object;
	private String successMessage;
	private String errorMessage;
	private int errorCode;
	private Object additionalObject;

	/**
	 * @return the additionalObject
	 */
	public Object getAdditionalObject() {
		return additionalObject;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * @param additionalObject
	 *            the additionalObject to set
	 */
	public void setAdditionalObject(Object additionalObject) {
		this.additionalObject = additionalObject;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @param successMessage
	 *            the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
