package com.ict.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ict.edu05.service.BbsService;
import com.ict.edu05.vo.BbsVO;

@Component
public class CommonScheduler {
	
	// Spring MVC에서 말하는 스케줄은 자동으로 주기적으로 특정 작업을 실행하기 위해 사용하는 기능
	// 1. 스케줄을 실행하는 클래스 생성((ex) CommonScheduler)
	// 2. 환경을 설정하는 클래스 생성((예)SchedulerConfig)
	
	// @Configuration
	// @EnableScheduling
	
	//3. 주기적으로 실행할 서비스를 @Autowired 한다.
	//4. 주기적으로 실행할 메서드를 만든다.
	// (Cron 표현식을 사용한다.)
	
	
	// cron 표현식
	// 초	|	분	|  시	|	일	|  월	|	요일			|  년	|
	//0-59   0-59    0-23    1-31    1-12    0-6(0=일요일)
	
	//  *  :  모든 값(매시, 매월, 매주처럼 사용한다)
	//	-	: 범위를 지정할 때
	//	/	:증분값, 즉 초기값과 증가치를 설정할 떼
	//	#	: N번째 특정 요일을 설정할 때 
	
	// 예시:
    // @Scheduled(cron = "0 0 0 * * *")          // 매일 자정
    // @Scheduled(cron = "0/10 * * * * *")       // 10초마다
    // @Scheduled(cron = "0 0/10 * * * *")       // 10분마다 (0,10,20,30,40,50분)
    // @Scheduled(cron = "0 10 * * * *")         // 매시간 10분에 실행
    // ─────────────────────────────────────────────
    // "0 0 9-18 * * MON-FRI"    평일 9시~18시 매시 정각
	
	
	
	@Autowired
	private BbsService bbsService;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void schedulerTest() {
		System.out.println("10초마다 실행됩니다.");
		List<BbsVO> list = bbsService.getBbsList();
		System.out.println("BBS 리스트의 크기 : " + list.size());
		
	}
	
	

}
