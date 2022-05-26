package com.callor.school.pesistance;

import java.util.List;
/*
 * Dao와 Service interface 에서 
 * 공통으로 구현할 interface를 만든다
 * 
 * 이 interface 는 2개의 Generic type 을 갖는다
 * 일단 VO와 PK 라는 이름으로 Generic type 을 선언해 두었다
 * 
 * 이 interface 를 상속하는 Dao나 Service interface 에서
 * 자신이 사용할 VO 클래스 타입과 PK 데이터 타입을 지정하여준다
 * 
 * 이 Generic Interface 를 사용하므로 써
 * Dao 나 Service interface 에서는 공통으로 구현할 method 를
 * 다시 작성하는 수고를 덜 수 있다
 * 
 */
public interface GenericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findById(PK id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
	
}
