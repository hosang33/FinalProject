package kr.ac.twoportal.web.controller;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.twoportal.dto.TuitionHisDto;
import kr.ac.twoportal.service.TuitionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/root-context.xml")
public class TutionControllerTest {
	/*
	 * 목표- 해당 학생이 결제한 등록금 내역들을 조건에 맞게 출력
	 * 연도 -전체 -2020 -2019 -2018
	 * 분기 -전반기 -후반기
	 */
	
	@Autowired
	private TuitionService tuitionService;
	
	
	@Test
	public void findTuitionPayHistoryList1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", 2020);
		map.put("quarter", "전반기");
		map.put("stuNo", 50000);
		List<TuitionHisDto> tuitionHisList = tuitionService.getTuitionPayHistoryList(map);
		assertNotNull(tuitionHisList);
		assertEquals(false,tuitionHisList.isEmpty());
		assertEquals(true, tuitionHisList.size() == 1);
	}
	@Test
	public void findTuitionPayHistoryList2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", "전체");
		map.put("quarter", "전반기");
		map.put("stuNo", 50000);
		List<TuitionHisDto> tuitionHisList = tuitionService.getTuitionPayHistoryList(map);
		
		assertEquals(false,tuitionHisList.isEmpty());
		assertEquals(true, tuitionHisList.size() > 0 ); //총 조회될 값
	}
	@Test
	public void findTuitionPayHistoryList3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", "전체");
		map.put("quarter", "전체");
		map.put("stuNo", 50000);
		List<TuitionHisDto> tuitionHisList = tuitionService.getTuitionPayHistoryList(map);
		
		assertEquals(false,tuitionHisList.isEmpty());
		assertEquals(true, tuitionHisList.size() > 0 );
	}

	
}
