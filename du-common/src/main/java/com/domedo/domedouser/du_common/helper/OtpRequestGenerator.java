package com.domedo.domedouser.du_common.helper;

import com.domedo.notificationservice.sdk.dto.OtpGenerateRequest;
import com.domedo.notificationservice.sdk.dto.OtpVerifyRequest;
import com.domedo.objects.enums.CountryCode;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
public class OtpRequestGenerator {

    public static OtpGenerateRequest makeGenerateOtpRequest(String mobileNumber) {
        OtpGenerateRequest otpGenerateRequest = new OtpGenerateRequest();
        OtpGenerateRequest.OtpGenerateRequestVo otpGenerateRequestVo = new OtpGenerateRequest.OtpGenerateRequestVo();
        otpGenerateRequestVo.setPhoneNumber(CountryCode.INDIA.getCountryCode() + mobileNumber);
        otpGenerateRequest.setOtpGenerateRequestVo(otpGenerateRequestVo);
        return otpGenerateRequest;
    }

    public static OtpVerifyRequest makeVerifyOtpRequest(String phoneNumber, String otp) {
        OtpVerifyRequest otpVerifyRequest = new OtpVerifyRequest();
        OtpVerifyRequest.OtpVerifyRequestVo otpVerifyRequestVo = new OtpVerifyRequest.OtpVerifyRequestVo();
        otpVerifyRequestVo.setOtp(otp);
        otpVerifyRequestVo.setPhoneNumber(CountryCode.INDIA.getCountryCode() + phoneNumber);
        otpVerifyRequest.setOtpVerifyRequestVo(otpVerifyRequestVo);
        return otpVerifyRequest;
    }
}
