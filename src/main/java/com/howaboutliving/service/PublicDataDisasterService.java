package com.howaboutliving.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.howaboutliving.dto.PublicDataDisaster;

@Service
public interface PublicDataDisasterService {
	List<PublicDataDisaster> selectPublicDataDisasterByDsstrRiskLc(String dsstrRiskLc);
}
