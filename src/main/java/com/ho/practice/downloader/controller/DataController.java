package com.ho.practice.downloader.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ho.practice.downloader.dto.Rawdata;
import com.ho.practice.downloader.repository.RawdataMongoDBRepository;

@RestController
@RequestMapping("/data")
public class DataController {

	@Value("${data-path}")
	private String dataPath;
	
	@Autowired
	RawdataMongoDBRepository rawdataMongoDBRepository;
	
	/**
	 * 특정 주기를 가진 센서의 데이터를 일자로 계산하여 csv파일로 저장한다.
	 * @param cycle
	 * @param day
	 * @return
	 */
    @PostMapping("/init")
    public String createDataFile(
    		@RequestParam(name = "cycle") Float cycle,
    		@RequestParam(name = "day") Integer day
    		) {
    	
    	// 파일에 저장
    	Rawdata rd = new Rawdata();
    	rd.setPk(cycle + "_" + day);
    	rd.setDataId("5d646c3c52faff00014cdb54");
    	rd.setSennsorId("C0003HZBD");
    	rd.setTimekey("20190827083316610");
    	rd.setRaw("0.520764,0.521080,0.520764,0.521396,0.520132,0.520764,0.520764,0.520764,0.520448,0.520448,0.520764,0.520764,0.521396,0.520132,0.521080,0.519816,0.520132,0.520132,0.519500,0.520132,0.519816,0.520448,0.520764,0.520448,0.520132,0.520132,0.520448,0.520132,0.520448,0.520764,0.520764,0.520764,0.520132,0.520132,0.519816,0.519816,0.519500,0.520764,0.520132,0.520448,0.520448,0.519184,0.520764,0.519816,0.520764,0.520764,0.520448,0.521080,0.521080,0.521396,0.520764,0.521396,0.521396,0.520764,0.520132,0.521080,0.520764,0.520448,0.521396,0.521080,0.521712,0.520448,0.521396,0.521080,0.520132,0.521080,0.521080,0.521080,0.520448,0.520764,0.520132,0.520764,0.520132,0.520132,0.520132,0.520132,0.520764,0.520764,0.520132,0.520132,0.521396,0.520764,0.521080,0.520448,0.520448,0.520448,0.521080,0.520132,0.521712,0.520132,0.520764,0.520764,0.520132,0.521080,0.520448,0.520132,0.521080,0.520764,0.520132,0.520448,0.520132,0.519816,0.520132,0.520764,0.520764,0.520764,0.520448,0.520764,0.520448,0.520132,0.520764,0.520132,0.520132,0.520132,0.519816,0.520448,0.520764,0.520764,0.519816,0.520132,0.520764,0.520132,0.520448,0.520448,0.520764,0.521396,0.520764,0.521396,0.521396,0.520764,0.520448,0.520764,0.520132,0.520764,0.520132,0.520448,0.520132,0.519500,0.520764,0.519500,0.520448,0.520132,0.521080,0.519816,0.520764,0.520448,0.520448,0.520132,0.520132,0.520448,0.520764,0.520448,0.520448,0.521396,0.520132,0.521080,0.520132,0.520448,0.520132,0.520764,0.521080,0.520764,0.519500,0.520764,0.520448,0.521080,0.521080,0.520132,0.520448,0.521080,0.521080,0.519816,0.520132,0.520764,0.520132,0.520448,0.520448,0.520448,0.520448,0.520448,0.519816,0.519500,0.520764,0.520132,0.520448,0.519816,0.519816,0.520448,0.520132,0.520132,0.520448,0.519816,0.521080,0.520764,0.520132,0.519184,0.520132,0.519816,0.519184,0.519184,0.519816,0.519816,0.520132,0.519816,0.519500,0.520132,0.520132,0.520132,0.519816,0.519816,0.519816,0.520132,0.520132,0.520764,0.519816,0.520764,0.520764,0.519816,0.520448,0.520764,0.520764,0.521396,0.520132,0.521396,0.520132,0.521396,0.521396,0.521712,0.520132,0.520448,0.520764,0.520764,0.521712,0.521396,0.521396,0.521080,0.521080,0.521396,0.521396,0.521080,0.521396,0.521396,0.521396,0.521396,0.520764,0.520764,0.520448,0.521080,0.521396,0.520764,0.520132,0.520448,0.521396,0.520448,0.520764,0.520448,0.520448,0.520764,0.520764,0.520764,0.520764,0.521396,0.521396,0.520448,0.521396,0.520764,0.520764,0.519816,0.521396,0.521080,0.520448,0.520448,0.520448,0.520132,0.521080,0.520764,0.520448,0.520448,0.520448,0.520132,0.521080,0.521712,0.520764,0.521080,0.520764,0.521396,0.521712,0.520764,0.520132,0.521396,0.520764,0.521080,0.521080,0.520764,0.521080,0.521712,0.522028,0.520448,0.522028,0.520448,0.520764,0.521712,0.521712,0.520764,0.520764,0.520764,0.522028,0.521396,0.520764,0.520764,0.521396,0.521396,0.521080,0.520448,0.520448,0.521396,0.520764,0.521080,0.520764,0.520764,0.520448,0.521396,0.520132,0.521080,0.521080,0.520448,0.521396,0.521080,0.520132,0.521396,0.521080,0.521080,0.522344,0.520448,0.520448,0.520448,0.520764,0.519816,0.520132,0.520448,0.521080,0.520132,0.519816,0.520132,0.519500,0.521080,0.520132,0.519816,0.520764,0.520448,0.520132,0.521396,0.520764,0.520448,0.521396,0.521080,0.520764,0.520764,0.520764,0.520132,0.521080,0.521080,0.520764,0.521080,0.521396,0.520448,0.521396,0.521712,0.521396,0.520764,0.520448,0.520764,0.521396,0.521712,0.520764,0.520764,0.521080,0.521080,0.521396,0.520764,0.520448,0.521080,0.520132,0.521080,0.521396,0.521080,0.520448,0.519816,0.520764,0.521080,0.520764,0.521080,0.521396,0.520764,0.521396,0.520764,0.520764,0.521080,0.520448,0.520132,0.520448,0.521396,0.520764,0.520448,0.521080,0.520764,0.520132,0.521080,0.520764,0.520764,0.520132,0.520448,0.521080,0.520132,0.520448,0.521080,0.520132,0.520448,0.519816,0.520132,0.520132,0.519816,0.521396,0.520448,0.521080,0.521712,0.521080,0.520132,0.520764,0.519816,0.519184,0.520448,0.521080,0.520764,0.522028,0.520764,0.520132,0.521712,0.520764,0.520448,0.521080,0.520448,0.520448,0.520448,0.520764,0.521396,0.520132,0.520448,0.520764,0.520764,0.519500,0.520448,0.520448,0.521080,0.520448,0.520448,0.521080,0.520448,0.520764,0.520764,0.521080,0.520764,0.520764,0.521080,0.520764,0.520448,0.520764,0.520448,0.520764,0.520764,0.520764,0.521396,0.520764,0.521396,0.520764,0.520448,0.521080,0.521712,0.521080,0.521396,0.521080,0.521712,0.521396,0.521712,0.520764,0.520764,0.521396,0.520448,0.520764,0.521396,0.521396,0.521712,0.521712,0.520764,0.520448,0.521080,0.520448,0.520764,0.520764,0.520764,0.520764,0.520448,0.520448,0.521080,0.520448,0.520764,0.520764,0.520764,0.521396,0.521396,0.520448,0.520764,0.520764,0.520764,0.520764,0.520448,0.520132,0.520764,0.521712,0.521396,0.521712,0.521396,0.521396,0.521080,0.521396,0.521712,0.521396,0.521396,0.522028,0.521712,0.522028,0.522344,0.521712,0.522344,0.522659,0.522659,0.522344,0.522659,0.522028,0.522659,0.522344,0.522659,0.522659,0.522659,0.523607,0.522975,0.522659,0.522975,0.522659,0.522659,0.522028,0.523291,0.523607,0.522659,0.522659,0.522659,0.522659,0.522975,0.522975,0.522975,0.522659,0.522028,0.522344,0.522659,0.522344,0.522028,0.521396,0.522344,0.522344,0.522344,0.522659,0.521712,0.522659,0.522028,0.521712,0.522975,0.522659,0.522659,0.521712,0.522659,0.522028,0.521396,0.522975,0.522028,0.522659,0.522028,0.522344,0.523607,0.522659,0.522659,0.522659,0.522344,0.522659,0.522975,0.521712,0.522975,0.522659,0.522659,0.522659,0.523607,0.522659,0.523291,0.522975,0.523291,0.522344,0.522659,0.522659,0.522344,0.522028,0.522344,0.522975,0.522344,0.522659,0.522028,0.523291,0.521396,0.522659,0.522028,0.522344,0.521712,0.522344,0.521396,0.522028,0.521712,0.521712,0.522659,0.522975,0.522028,0.521712,0.522028,0.521712,0.522028,0.522028,0.522028,0.522659,0.522028,0.522344,0.522028,0.522975,0.522344,0.523291,0.522659,0.522975,0.522659,0.523291,0.523291,0.523291,0.523291,0.523923,0.522659,0.522975,0.523607,0.523607,0.523607,0.523291,0.523291,0.523607,0.523291,0.523923,0.523291,0.522659,0.523607,0.522975,0.522975,0.523923,0.522975,0.523291,0.522659,0.522344,0.523607,0.523607,0.522975,0.522975,0.523291,0.523607,0.523291,0.522975,0.523291,0.523607,0.522659,0.523291,0.522975,0.522659,0.522975,0.522975,0.523291,0.523291,0.523607,0.523923,0.524239,0.523607,0.523607,0.523607,0.524555,0.523923,0.523923,0.523607,0.523923,0.523923,0.524239,0.524239,0.523291,0.524555,0.523923,0.523607,0.523923,0.524239,0.524239,0.524555,0.524239,0.524871,0.524871,0.524555,0.524871,0.524871,0.524555,0.524239,0.524239,0.524871,0.525187,0.524555,0.524871,0.523923,0.523923,0.523923,0.524555,0.523923,0.524239,0.524555,0.523923,0.524239,0.523607,0.524239,0.524871,0.523923,0.524239,0.524555,0.524239,0.524555,0.524555,0.524871,0.524555,0.524555,0.523923,0.525187,0.523923,0.524239,0.523923,0.523923,0.523923,0.523607,0.523923,0.524555,0.524239,0.523607,0.524555,0.523923,0.524239,0.523923,0.523607,0.522975,0.523923,0.524239,0.524239,0.522975,0.524239,0.524239,0.523923,0.523607,0.524239,0.523607,0.523291,0.523607,0.523923,0.523291,0.522975,0.523607,0.522975,0.523923,0.522975,0.522975,0.523607,0.522659,0.524555,0.522975,0.523291,0.522975,0.523923,0.522975,0.523923,0.522659,0.523291,0.523923,0.522659,0.522975,0.523923,0.523607,0.523607,0.522975,0.522344,0.523291,0.523607,0.523607,0.523607,0.523923,0.523291,0.524555,0.523607,0.524871,0.523923,0.523923,0.523923,0.522975,0.523291,0.523923,0.522975,0.523923,0.523923,0.523291,0.524871,0.523607,0.524239,0.523291,0.523923,0.524239,0.523923,0.522975,0.523607,0.522975,0.523607,0.522659,0.523923,0.524239,0.523291,0.523923,0.523607,0.523291,0.523291,0.523607,0.522975,0.523291,0.523923,0.523291,0.523607,0.523291,0.522975,0.524239,0.522975,0.522975,0.524239,0.523291,0.523607,0.522975,0.523607,0.523291,0.523923,0.522659,0.522975,0.523291,0.523607,0.523923,0.522659,0.522975,0.523607,0.522659,0.523923,0.523607,0.522975,0.522975,0.523291,0.523607,0.522659,0.523291,0.522975,0.522975,0.523291,0.523607,0.522659,0.523291,0.523291,0.523291,0.523607,0.522975,0.523607,0.522344,0.522659,0.522344,0.523291,0.523291,0.522659,0.522028,0.522975,0.522659,0.522344,0.522028,0.522344,0.522659,0.522344,0.522659,0.522344,0.523607,0.522975,0.522659,0.523291,0.523291,0.522975,0.523607,0.522028,0.523607,0.522659,0.523291,0.522659,0.522659,0.523923,0.522975,0.523291,0.522659,0.522028,0.522344,0.522659,0.521712,0.522659,0.522028,0.522659,0.522659,0.522659,0.522344,0.521396,0.523607,0.522975,0.522659,0.522659,0.522028,0.522659,0.522344,0.522344,0.522659,0.522344,0.522659,0.521712,0.523607,0.522028,0.522028,0.522975,0.522344,0.522659,0.523291,0.522975,0.523607,0.522659,0.522659,0.522975,0.522659,0.523291,0.522344,0.522975,0.522659,0.522659,0.522659,0.522028,0.522344,0.522344,0.522659,0.521712,0.522028,0.522028,0.522028,0.521396,0.522028,0.522028,0.522028,0.522028,0.522344,0.522028,0.522344,0.521712,0.522028,0.523291,0.522028,0.522028,0.522028,0.521080,0.522028,0.522028,0.520764,0.521080,0.521712,0.521712,0.521396,0.521396,0.522028,0.521396,0.522028,0.521712,0.521396,0.521080,0.522659,0.522028,0.521712,0.522028,0.521396,0.522028,0.521080,0.522344,0.521080,0.522344,0.522975,0.522028,0.521712,0.521712,0.521080,0.522028,0.521712,0.521712,0.521712,0.522028,0.522659,0.521712,0.521396,0.520764,0.522028,0.521396,0.521396,0.521396,0.521396,0.521396,0.522028,0.521396,0.520448,0.521396,0.521080,0.521080,0.521396,0.521080,0.520448,0.521080,0.520132,0.521396,0.521080,0.522028,0.521080,0.521396,0.520764,0.520448,0.521080,0.521712,0.521396,0.521080,0.521396,0.521396,0.521396,0.521396,0.520448,0.521396,0.521080,0.520448,0.520764,0.520764,0.521396,0.520448,0.520764,0.521080,0.521396,0.521712,0.520764,0.520764,0.521396,0.521712,0.521080,0.520764,0.520764,0.521396,0.520448,0.520764,0.520764,0.520764,0.520448,0.521396,0.521396,0.520448,0.521080,0.520448,0.520764,0.520448,0.520764,0.520764,0.519816,0.520764,0.520448,0.520132,0.520132,0.520764,0.521080,0.520764,0.520764,0.520764,0.520132,0.521080,0.520132,0.520132,0.520448,0.520448,0.519816,0.521396,0.520448,0.521080,0.520448,0.520132,0.519500,0.521080,0.519816,0.520132,0.519184,0.519816,0.520764,0.519816,0.519816,0.520132,0.520132,0.521080,0.520132,0.519500,0.520448,0.520132,0.520448,0.520132,0.519500,0.520448,0.521080,0.519816,0.520132,0.521080,0.520448,0.519500,0.519816,0.519816,0.520448,0.520448,0.519816,0.519500,0.520764,0.519816,0.520132,0.520132,0.520132,0.520448,0.520448,0.520132,0.520764,0.520448,0.521080,0.520132,0.521396,0.520448,0.520132,0.519816,0.520132,0.520448,0.519816,0.519816,0.520132,0.519816,0.520132,0.520448,0.520764,0.520132,0.520132,0.520448,0.520448,0.520132,0.520132,0.519816,0.520132,0.519500,0.518868,0.520448,0.520132,0.519184,0.519816,0.519500,0.519500,0.519184,0.519816,0.519184,0.519184,0.519500,0.519500,0.519184,0.519816,0.519184,0.519816,0.519184,0.518868,0.519500,0.519184,0.519500,0.519184,0.519500,0.519500,0.520764,0.519184,0.519500,0.520132,0.520132,0.519500,0.520132,0.520132,0.519500,0.518868,0.520132,0.520448,0.519500,0.520448,0.520132,0.520132,0.519816,0.520132,0.519184,0.520132,0.520132,0.519500,0.520132,0.519184,0.520132,0.519500,0.519184,0.519500,0.519500,0.519184,0.520132,0.519500,0.519816,0.519816,0.520132,0.520448,0.520448,0.520132,0.520132,0.519816,0.519816,0.519816,0.519500,0.519184,0.519816,0.520132,0.519184,0.520132,0.520132,0.520132,0.520132,0.520132,0.520132,0.519184,0.519816,0.519816,0.520448,0.519816,0.519816,0.519184,0.520764,0.519500,0.520132,0.520132,0.519816,0.520132,0.519816,0.519184,0.520132,0.518868,0.520448,0.519184,0.519500,0.519500,0.519184,0.519500,0.519500,0.520132,0.520132,0.519184,0.518868,0.519500,0.519184,0.519500,0.519500,0.520132,0.519500,0.519500,0.519500,0.519184,0.519184,0.518868,0.519500,0.518236,0.519500,0.519184,0.519184,0.519500,0.518868,0.519184,0.518868,0.518868,0.520132,0.519184,0.519184,0.519500,0.520132,0.519500,0.519184,0.520448,0.519184,0.519500,0.519500,0.520132,0.519184,0.520764,0.519816,0.520132,0.519500,0.519816,0.519816,0.519816,0.520448,0.520132,0.520448,0.519184,0.520448,0.520132,0.520764,0.520448,0.520764,0.519500,0.520132,0.521080,0.519816,0.519816,0.520132,0.520448,0.519500,0.520764,0.520132,0.520132,0.520448,0.520132,0.520132,0.519816,0.519816,0.520132,0.519816,0.520132,0.520132,0.520132,0.520764,0.520448,0.520764,0.520448,0.520448,0.520132,0.520448,0.520132,0.519816,0.519816,0.520448,0.519500,0.519500,0.519500,0.519816,0.520132,0.520764,0.520132,0.519184,0.519500,0.519816,0.520132,0.519500,0.519816,0.520132,0.519500,0.520132,0.520448,0.519816,0.519816,0.518868,0.520132,0.519500,0.519184,0.520132,0.520132,0.519500,0.520448,0.520764,0.520132,0.519816,0.519500,0.520764,0.519184,0.520132,0.519816,0.520448,0.519816,0.520132,0.519816,0.519816,0.520764,0.519184,0.519500,0.519184,0.520132,0.519184,0.520448,0.519816,0.520132,0.520132,0.520448,0.519500,0.519816,0.520764,0.519816,0.520132,0.519816,0.520448,0.520448,0.520132,0.520448,0.520764,0.520132,0.520764,0.520132,0.521080,0.520132,0.520132,0.520132,0.520448,0.519500,0.519184,0.520132,0.518868,0.519816,0.520448,0.520132,0.519500,0.519500,0.519500,0.519500,0.520132,0.520132,0.519184,0.519816,0.520448,0.519500,0.520448,0.519500,0.519500,0.520132,0.519816,0.519816,0.519500,0.519184,0.519816,0.519816,0.519500,0.520132,0.519500,0.519816,0.518868,0.519500,0.519816,0.520448,0.519184,0.520132,0.519500,0.519816,0.519184,0.520448,0.519184,0.520448,0.518868,0.520132,0.520132,0.518868,0.519816,0.520132,0.518868,0.519184,0.520132,0.520132,0.519816,0.520132,0.520132,0.519816,0.520448,0.520132,0.520764,0.520448,0.520132,0.520132,0.520132,0.521080,0.520448,0.520132,0.520448,0.520132,0.520764,0.519816,0.519500,0.520132,0.519816,0.520132,0.520132,0.520448,0.520132,0.520132,0.519816,0.519816,0.520448,0.520132,0.520448,0.520132,0.520448,0.520132,0.520132,0.519500,0.519500,0.519500,0.520132,0.519816,0.520132,0.520132,0.519500,0.520132,0.519500,0.520448,0.519816,0.519816,0.519500,0.520132,0.519816,0.519184,0.519184,0.519184,0.520132,0.520132,0.520132,0.520448,0.520132,0.519816,0.520448,0.520132,0.520132,0.519816,0.519816,0.519184,0.520448,0.520132,0.520448,0.520764,0.520132,0.520132,0.520132,0.520448,0.520448,0.519816,0.520132,0.520132,0.519816,0.520448,0.519816,0.520132,0.520764,0.521396,0.520448,0.520448,0.520132,0.518868,0.520764,0.519816,0.519500,0.520132,0.520764,0.519500,0.520764,0.520132,0.520448,0.520132,0.519816,0.520132,0.519184,0.519184,0.519184,0.520448,0.519500,0.520132,0.520132,0.520132,0.519816,0.519816,0.519184,0.519500,0.519184,0.519184,0.519184,0.518552,0.519184,0.519816,0.519184,0.519500,0.520132,0.519184,0.520448,0.519816,0.519500,0.519500,0.519816,0.520132,0.520132,0.519500,0.520132,0.521080,0.520132,0.520764,0.521080,0.521080,0.520448,0.520132,0.521396,0.521080,0.520764,0.521396,0.521080,0.521080,0.521080,0.520132,0.520764,0.521396,0.520764,0.520764,0.520132,0.520448,0.520764,0.519184,0.519816,0.520448,0.520764,0.520132,0.520132,0.519500,0.520132,0.519816,0.521080,0.521080,0.519500,0.521080,0.520132,0.520764,0.520448,0.520448,0.520448,0.520448,0.519816,0.521080,0.520132,0.520764,0.520448,0.521080,0.520448,0.519816,0.521396,0.520764,0.520764,0.520448,0.520764,0.520448,0.520448,0.520764,0.521080,0.520448,0.520764,0.520132,0.520132,0.520764,0.520764,0.520132,0.520448,0.519816,0.520132,0.520764,0.519500,0.520132,0.520764,0.520448,0.520132,0.520764,0.520132,0.520764,0.521080,0.520132,0.521080,0.520764,0.520448,0.520448,0.520448,0.520132,0.520448,0.520132,0.520764,0.520132,0.519500,0.519816,0.520132,0.520132,0.520764,0.520132,0.518868,0.520764,0.520764,0.519816,0.520132,0.520132,0.519816,0.520764,0.520132,0.520132,0.520448,0.520448,0.520448,0.521080,0.520132,0.520764,0.520132,0.520448,0.519816,0.521080,0.520764,0.520448,0.520448,0.520764,0.521080,0.520448,0.520132,0.520132,0.520448,0.520448,0.520764,0.520448,0.520448,0.520132,0.520448,0.520764,0.520132,0.520132,0.520132,0.520132,0.519816,0.521080,0.520132,0.520764,0.520448,0.520132,0.519816,0.520448,0.520764,0.520764,0.520764,0.520448,0.520764,0.520764,0.519816,0.520132,0.520764,0.519816,0.520132,0.520448,0.520132,0.519500,0.519816,0.520132,0.520132,0.520132,0.519500,0.520132,0.520448,0.520448,0.519816,0.519500,0.520448,0.520764,0.519816,0.519816,0.519500,0.520132,0.520132,0.520132,0.519816,0.519500,0.520132,0.519500,0.520132,0.519816,0.520764,0.519184,0.519816,0.520132,0.520448,0.520132,0.520132,0.521080,0.521080,0.520764,0.519816,0.520764,0.520132,0.520132,0.520132,0.520132,0.519816,0.520132,0.520132,0.519816,0.520132,0.520132,0.520132,0.520132,0.519184,0.519816,0.520764,0.520132,0.520132,0.520764,0.521080,0.519500,0.521396,0.520132,0.520132,0.521396,0.520448,0.520448,0.520448,0.520132,0.520448,0.521396,0.520132,0.520132,0.520448,0.521080,0.520448,0.520448,0.520132,0.520448,0.520132,0.520132,0.520132,0.519816,0.520132,0.520132,0.520448,0.520448,0.521080,0.519500,0.520764,0.519500,0.519500,0.520132,0.520448,0.520132,0.521080,0.520764,0.520448,0.519816,0.519816,0.520132,0.519816,0.520764,0.520448,0.520448,0.519816,0.520448,0.520448,0.520764,0.519500,0.519184,0.520132,0.520132,0.520448,0.520132,0.520132,0.520132,0.519816,0.520448,0.519500,0.520448,0.520132,0.519816,0.520132,0.519816,0.520132,0.520764,0.520448,0.520764,0.520448,0.520132,0.520132,0.521080,0.520764,0.519500,0.520448,0.520448,0.520764,0.520132,0.519500,0.521080,0.520764,0.520132,0.520132,0.521396,0.520132,0.520448,0.520764,0.521080,0.519816,0.520132,0.520448,0.519816,0.520132,0.520132,0.520132,0.520764,0.520448,0.520448,0.520132,0.520448,0.519816,0.520132,0.520448,0.520764,0.520764,0.521080,0.520448,0.519816,0.520132,0.520448,0.520448,0.521396,0.520764,0.520764,0.519816,0.520448,0.520132,0.520764,0.520448,0.520132,0.520448,0.520132,0.520764,0.519500,0.520448,0.519500,0.520448,0.520132,0.520132,0.519816,0.520132,0.520132,0.520132,0.520448,0.520764,0.520764,0.520132,0.520764,0.519816,0.521080,0.519816,0.521080,0.520448,0.520764,0.519500,0.520132,0.519816,0.520132,0.520132,0.519500,0.520448,0.520132,0.520448,0.519816,0.520132,0.519500,0.520132,0.519816,0.519816,0.520132,0.520132,0.519184,0.519816,0.520132,0.521396,0.520448,0.520448,0.520132,0.519816,0.520764,0.519816,0.520764,0.519816,0.520764,0.519500,0.520132,0.520764,0.520764,0.520132,0.520764,0.520132,0.520448,0.520132,0.520132,0.520448,0.520764,0.520132,0.520448,0.520764,0.520448,0.520448,0.519816,0.520764,0.519816,0.519816,0.520448,0.520132,0.519500,0.520448,0.520764,0.519816,0.521396,0.520764,0.521080,0.520132,0.521080,0.520132,0.520132,0.521080,0.520448,0.520132,0.520448,0.520132,0.520764,0.521080,0.520448,0.521080,0.520132,0.520764");
    	rd.setTtlDate("2019-08-27T08:33:16.610Z");
    	
    	// header : id, sennsor_id, timekey, raw, ttl_date
    	String row = rd.toString();
    	Float rowCnt = (day*24*60*60)/cycle;
    	
    	try {
    		File f = new File(dataPath+"/data_" + cycle + "_" + day + ".csv");
    		if(!f.exists()) {
    			f.createNewFile();
    			
    			PrintWriter writer = new PrintWriter(f);
    			for (int i = 0; i < rowCnt; i++) {
    				writer.println(row);
    			}
    			writer.close();
    		}
    	} catch (IOException e) {
			e.printStackTrace();
			return "fail, message : " + e.getMessage();
		}
    	
    	// DB에 저장
    	List<Rawdata> list = new ArrayList<>();
    	for (int i = 0; i < rowCnt; i++) {
			list.add(rd);
		}
    	rawdataMongoDBRepository.deleteByPk(rd.getPk());
    	rawdataMongoDBRepository.insert(list);
    	
    	return "success";
    }
    
    /**
     * CSV파일을 읽어서 outputstream으로 전송
     * @param cycle
     * @param day
     * @param response
     * @return
     * @throws IOException 
     */
    @GetMapping("/file/{cycle}/{day}")
    public void getDataFromFile(@PathVariable String cycle,
    		@PathVariable String day,
    		HttpServletResponse response) throws IOException {
    	File f = new File(dataPath+"/data_" + cycle + "_" + day + ".csv");
    	if(!f.exists()) {
    		throw new FileNotFoundException(f.getAbsolutePath());
    	}
    	//입력 스트림 생성
        FileReader filereader = null;
		try {
			response.setContentType("text/csv;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename="+ "rawdata_" + cycle + "_" + day + ".csv");
			response.setHeader("Content-Length", "" + f.length());
	    	PrintWriter out = response.getWriter();
	    	
			filereader = new FileReader(f);
			int singleCh = 0;
	        while((singleCh = filereader.read()) != -1){
	        	out.print((char)singleCh);
	        }
	        filereader.close();
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if(filereader != null) {
				try {
					filereader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    /**
     * 데이터를 메모리에 전부 로드후  다운로드
     * @param cycle
     * @param day
     * @param response
     * @return
     * @throws IOException 
     */
    @GetMapping("/db/load/{cycle}/{day}")
    public void getDataLoadFromDB(@PathVariable String cycle,
    		@PathVariable String day,
    		HttpServletResponse response) throws IOException {
    	List<Rawdata> list = rawdataMongoDBRepository.findByPk(cycle + "_" + day);
    	
    	//입력 스트림 생성
        try {
			response.setContentType("text/csv;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename="+ "rawdata_" + cycle + "_" + day + ".csv");
	    	PrintWriter out = response.getWriter();
	    	
	    	for (Rawdata rawdata : list) {
	    		out.println(rawdata.toString());
			}
		} catch (IOException e) {
			throw e;
		}
    }

    /**
     * 데이터를 스트림으로 불러 다운로드 스트림으로 전달
     * @param cycle
     * @param day
     * @param response
     * @return
     * @throws IOException 
     */
    @GetMapping("/db/stream/{cycle}/{day}")
    public void getDataStreamFromDB(@PathVariable String cycle,
    		@PathVariable String day,
    		HttpServletResponse response) throws IOException {
    	Stream<Rawdata> stream = rawdataMongoDBRepository.readByPk(cycle + "_" + day);
    	
    	//입력 스트림 생성
        try {
        	response.setContentType("text/csv;charset=EUC-KR");
			response.setHeader("Content-disposition", "attachment; filename="+ "rawdata_" + cycle + "_" + day + ".csv");
			
	    	PrintWriter out = response.getWriter();
	    	stream.forEach(data -> out.println(data.toString()));
	    	out.flush();
		} catch (IOException e) {
			throw e;
		}
    }
    
    /**
     * 데이터를 스트림으로 불러 다운로드 스트림으로 전달
     * @param cycle
     * @param day
     * @param response
     * @return
     * @throws IOException 
     */
    @GetMapping("/db/stream/find/{cycle}/{day}")
    public void getDataFindStreamFromDB(@PathVariable String cycle,
    		@PathVariable String day,
    		HttpServletResponse response) throws IOException {
    	Stream<Rawdata> stream = rawdataMongoDBRepository.findById(cycle + "_" + day).stream();
    	
    	//입력 스트림 생성
        try {
        	response.setContentType("text/csv;charset=EUC-KR");
			response.setHeader("Content-disposition", "attachment; filename="+ "rawdata_" + cycle + "_" + day + ".csv");
	    	
			PrintWriter out = response.getWriter();
	    	stream.forEach(data -> out.println(data.toString()));
	    	out.flush();
		} catch (IOException e) {
			throw e;
		}
    }
    
}
