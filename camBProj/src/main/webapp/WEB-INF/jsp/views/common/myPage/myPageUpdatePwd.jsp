<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	 #sec{
	 	font-family: 'Hanna', sans-serif;
	 }
	 #myPage{
	 	font-family: 'Hanna', sans-serif;
	 }
	table {
	  border-collapse: separate;
	  border-spacing: 10rem 1rem;
	}
	input {
		width: 100%
	}

</style>
<div id="body">
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<div style="width: 96%;">
	<div class="card shadow mb-4" style="width: 65%; margin-left: 285px;">
		<div class="card-header py-3"><!--마이페이지 글씨 써있는 부분  -->
			<p class="m-0 font-weight-bold text-primary" id="myPage"  style="font-size: 1em;">
				비밀번호 수정 <br>
			</p>
		</div>
<div id="sec">
	<form action="/common/myPage/updatePwdPost" method="post" id="mpFrm">
		<div class="card-body" style="width: 95%"><!--내용 흰색 칸  -->
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"><!--흰색 칸안의칸  -->
				<br>
				<div>
						<input type="hidden" name="memId" value="${memberVo.memId}" readonly="readonly">
					<table>
						<tr> 
							<td class="td1" style="width: 200px;"><h5>새로운  비밀번호</h5></td>
							<td>
								<input class="form-control" type="password" id="pwdChange" maxlength="30px;" class="pw">
								<h6 id="checkNumber" style="display: none; color: #d92742; font-weight: bold; ">입력한 글자가 8글자 이상이어야 합니다.</h6>
								<h6>8~15자리의 영문, 숫자, 특수문자의 입력이 가능합니다.</h6>
							</td>
						</tr>
						<tr> 
							<td class="td1"><h5>비밀번호 확인</h5	></td>
							<td>
								<input class="form-control" type="password" id="pwdCheck" name="pwd" maxlength="30px;" class="pw">
								<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
	   							<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">입력한 비밀번호가 서로 일치하지 않습니다.</span>
							</td>
						</tr>
					</table>
				</div>
					<br>
					<hr style="margin-left: 20px;">
				<div style="float: left; position: relative; left: 340px;">
					<button type="button" class="btn btn-primary" id="btnUpdate" style=" width: 130px; height: 50px; font-size: 1em;">수정</button> &nbsp;&nbsp;&nbsp;
					<button class="btn btn-light" style= "background-color: gray; color:white; width: 130px; height: 50px; font-size: 1em;" onclick = "javascript:history.go(-1)">취소</button>
				</div>
			
			<br>
					
			</div><!--흰색 칸안의 칸  -->
		</div><!--내용 흰색 칸  -->
	</form>
	</div>
	<br><br>
</div>
</div>
	<script type="text/javascript">
	
	
	$(function() {
		
		$('.pw').focusout(function () {
			checkVal();
	    });	
		
		$("#btnUpdate").on("click", function () {
			var str = checkVal();
			if(str == "true"){
				$("#mpFrm").submit();
			}
		});
		
		function checkVal() {
			
			var pwd1 = $("#pwdChange").val();
	        var pwd2 = $("#pwdCheck").val();
			
			if ( pwd1 != '' && pwd2 == '' ) {
				return false;
	        } else if (pwd1 != "" || pwd2 != "") {
	        	
	        	if(pwd1.length < 8) {
//	 	              alert('입력한 글자가 8글자 이상이어야 합니다.');
					 $("#checkNumber").css('display', 'inline-block');
					 return false;
		         }else{
	 				 $("#checkNumber").css('display', 'none');
		         }
	        	
	            if (pwd1 == pwd2) {
	                $("#alert-success").css('display', 'inline-block');
	                $("#alert-danger").css('display', 'none');
	                return "true";
	            } else {
	                $("#alert-success").css('display', 'none');
	                $("#alert-danger").css('display', 'inline-block');
	                return "false";
	            }
	        }
		}
		
		
	});

	</script>

</div>
