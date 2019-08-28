package com.ho.practice.downloader.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ho.practice.downloader.dto.Rawdata;

public interface RawdataMongoDBRepository extends MongoRepository<Rawdata, String> {

	void deleteByPk(String pk);

	List<Rawdata> findByPk(String pk);

	Stream<Rawdata> readByPk(String string);
	 
}
