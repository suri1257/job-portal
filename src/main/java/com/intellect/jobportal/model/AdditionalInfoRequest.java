package com.intellect.jobportal.model;

import com.intellect.jobportal.model.common.BaseRequest;

public class AdditionalInfoRequest extends BaseRequest{
	private AdditionalInfo additionalInfo;

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
