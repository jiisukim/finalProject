<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="body" class="text-center">
	<img alt="에러 이미지" class="errorImg" src="/resources/img/error/error.png">
	<h5>에러가 발생했습니다</h5>
	<button type="button" class="btn btn-primary" onclick="location.href='${viewUrl}'">
		${viewStr}페이지로 돌아가기
	</button>
</div>