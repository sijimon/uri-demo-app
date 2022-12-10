package com.sijimon.uridemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sijimon.uridemoapp.module.PayloadData;
import com.sijimon.uridemoapp.utils.AESCryptoUtility;

@RestController
public class URIDemoController {
	
	@Autowired
	private AESCryptoUtility encryptorAesGcm;

	@RequestMapping(value = "/api/v1/sample/encrypt", method = RequestMethod.POST)
	public String encryptURL(@RequestBody PayloadData payload) throws Exception {		
		String baseURL = payload.getBaseurl();	
		String payloaddata = payload.getPayload();
		
		String estr = encryptorAesGcm.encrypt(baseURL, payload.getEncryptpasscode());	
		return estr;
	}
	
	@RequestMapping(value = "/api/v1/sample/decrypt", method = RequestMethod.POST)
	public String decryptURL(@RequestBody PayloadData payload) throws Exception {		
		String baseURL = payload.getBaseurl();		
		String estr = encryptorAesGcm.decrypt(baseURL, payload.getEncryptpasscode());	
		return estr;
	}
	
	

}
