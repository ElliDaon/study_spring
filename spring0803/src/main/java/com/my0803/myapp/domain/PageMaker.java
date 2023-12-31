package com.my0803.myapp.domain;

import org.springframework.stereotype.Component;

//하단 페이지 네비게이션에 필요한 변수들의 집합 데이터 클래스
@Component
public class PageMaker {
	private int displayPageNum = 10; //보여지는 페이지 목록 갯수
	private int startPage; //목록의 시작 번호
	private int endPage; //목록의 끝 번호
	private int totalCount; //총 게시물 수 담는 변수
	
	private boolean prev; //이전버튼 존재 유무
	private boolean next; //다음버튼 존재 유무
	
	private SearchCriteria scri;
	
	
	public SearchCriteria getScri() {
		return scri;
	}

	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		CalcData(); //페이지 목록 갯수 나타내주기 위한 계산식
	}

	private void CalcData() {
		//1. 기본적으로 1에서 10까지 나타나게 설정
		endPage = (int)Math.ceil(scri.getPage()/(double)displayPageNum)*displayPageNum;
		
		//2. end 페이지를 설정했으면 시작 페이지도 설정하자~!
		startPage = (endPage-displayPageNum)+1;
		
		//3. 실제 페이지 값을 뽑겠다!!!
		int tempEndPage = (int)Math.ceil(totalCount/(double)scri.getPerPageNum());
		
		//4. 설정 endPage와 실제 endPage를 비교한다.
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//5. 이전 다음 버튼 유무
		prev = (startPage == 1 ? false:true);
		next = (endPage*scri.getPerPageNum() >= totalCount ? false:true);
		
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	
}
