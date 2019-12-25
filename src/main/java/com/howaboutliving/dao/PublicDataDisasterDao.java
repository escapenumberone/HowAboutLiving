package com.howaboutliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataDisaster;

@Repository
public interface PublicDataDisasterDao {
	void insertPublicDataDisaster(List<PublicDataDisaster> list);
	void deleteDisaster();
	void autoIncrementResetDisaster();
}
