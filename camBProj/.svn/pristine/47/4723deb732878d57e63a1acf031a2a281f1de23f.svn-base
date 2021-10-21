<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
 	 .modalTable td{
	 	height: 125px;
	 }
	 .modalTable th{
	 	background-color: #486DDB;
	 	color: white;
	 	height: 50px;
	 	text-align: center;
	 }
	 .modalTable th:first-child{
	 	border-radius: 10px 0px 0px 0px;
	 }
	 .modalTable th:last-child{
	 	border-radius: 0px 10px 0px 0px;
	 }
	 .modalTable tr:last-child > td:last-child{
	 	border-radius: 0px 0px 10px 0px;
	 }
	 .modalTable tr:last-child > td:nth-last-child(2){
	 	border-radius: 0px 0px 0px 10px;
	 }

	 .modalTable td,.modalTable th{
	 	border: 1px solid gray;  
	 }
	 .modalTable tr:nth-child(even){
	 	background-color: #F7F8FB;
	 }
	 .modalTable tr:nth-child(odd){
	 	background-color: #FFFFFF;
	 }
	 
	 input[type="number"]::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	    margin: 0;
	}
@media print {
	* {
		-webkit-print-color-adjust: exact;
		print-color-adjust: exact;
    }
}
</style>

<div id="body">


<!--강의 계획서 Modal -->
	  <div class="modal fade bd-example-modal-xl" id="myModal" role="dialog"  data-backdrop="static"> <!-- 사용자 지정 부분① : id명 -->
	    <div class="modal-dialog modal-xl">
	      <!-- Modal content-->
	      <div class="modal-content" style="border-radius:20px 20px 8px 8px !important; border: 0px;">
	        <div class="modal-header" style="background-color: #486DDB; border-radius: 8px 8px 0px 0px !important;">
	          <p class="modal-title" style="color: white; font-weight: bold; ">강의 계획서</p> <!-- 사용자 지정 부분② : 타이틀 -->
	          <button type="button" class="close" data-dismiss="modal" style="color: white;">×</button>
	        </div>
	        <div class="modal-body">
	        	<button type="button" class="btn btn-secondary" style="float: left;" onclick="fn_print_capture()">인쇄 & 저장</button>
	        	
	        	<br><br>
	        	
	        	<!-- 인쇄 영역 -->
	        	<div id="box_pdf_content">
		          	<div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 2% 3% 3% 3%; height: 300px; background-color: #F4F5F9;">
		          		<input type="hidden" value="${syllabusvo.sylNum}" name="sylNum" id="sylNum"> <!-- 강의계획서 번호 히든 -->
		          		 
		          		<div style="float: left; width: 22%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">교과 번호</span> <br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="subjNum" disabled="disabled" > <!-- 학수번호 -->
		          			<input type="hidden" name="subjNum" value="${lectureOpenVO.subjNum}" > <!-- 학수번호 -->
		          			
		          		</div>
		          		<div style="float: left; width: 22%; margin-left: 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">담당교수</span> <br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;"  id="nameModal" disabled="disabled"> <!--  담당교수 -->
		          			<input type="hidden" name="profId" value="${lectureOpenVO.profId}"> <!--  담당교수 -->
		          		</div>
		          		<div style="float: left; width: 22%; margin-left: 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">E-mail</span><br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="email" disabled="disabled"> <!--  E-mail --> 
		          			<input type="hidden" name="email" value="${syllabusvo.email}"> <!--  E-mail --> 
		          		</div>
		          		<div style="float: left; width: 22%; margin-left: 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">분반</span> <br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="divideNum" disabled="disabled"> <!--  분반 -->
		          			<input type="hidden"  value="${lectureOpenVO.divideNum}"> <!--  분반 -->
		          		</div>
		          		 
		          		<div style="float: left; width: 22%; margin-top: 1%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">전화번호</span><br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="phNum" disabled="disabled"> <!--  전화번호 -->
		          			<input type="hidden" value="${syllabusvo.phNum}"> <!--  전화번호 -->
		          		</div> 
		          		<div style="float: left; width: 22%; margin:1% 0% 0% 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">강의방법 </span><br/>
		          			<input class="okModify" name="lectMethod" id="lectMethod" type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="lectMethod" disabled="disabled"> <!--  강의방법 -->
		          		</div> 
		          		<div style="float: left; width: 22%; margin:1% 0% 0% 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">개설학과(부)</span><br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="univDeptNameModal" disabled="disabled"> <!--  개설학과 -->
		          			<input type="hidden"  value="${lectureOpenVO.univDeptNum}"> <!--  개설학과 -->
		          		</div> 
		          		<div style="float: left; width: 22%; margin:1% 0% 0% 4%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">교과구분 </span><br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="subjTypeCodeName" disabled="disabled"> <!--  교과구분 -->
		          			<input type="hidden" value="${lectureOpenVO.subjTypeCode}"> <!--  교과구분 -->
		          		</div> 
		        
		        
		        		<div style="float: left; width: 48%; margin-top: 1%;">
		          			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">교과목명 </span><br/>
		          			<input type="text" style="border-radius:6px; border: 1px solid gray; height: 40px; width: 100%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" id="lectNameModal" disabled="disabled"> 
		          			<input type="hidden" value="${lectureOpenVO.lectName}"> 
		          		</div> 
		          	</div>
		          	<br/>
		          	<div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 1% 2%; height: 220px; background-color: #F4F5F9;">
			       			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">강의 개요(Course Description) </span><br/>
			       			<textarea class="okModify" id="lectOvr" name="lectOvr" rows="5" cols="33" style="border-radius:5px; border: 1px solid gray; width: 99%; margin: 6px; resize: none; padding: 12px; background-color: #F1F2F8;" disabled="disabled" >${syllabusvo.lectOvr}</textarea>
		          		
		          	</div>
		          	
		          	<br/>
		          	<div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 1% 2%; height: 220px; background-color: #F4F5F9;">
			       			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">수업 목표 (Course Objective) </span><br/>
			       			<textarea class="okModify" rows="5" cols="33" style="border-radius:5px; border: 1px solid gray; width: 99%; margin: 6px; resize: none; padding: 12px; background-color: #F1F2F8;" disabled="disabled" name="lectGoal" id="lectGoal"></textarea>
		          	</div>
		          	<br/>
			        <div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 2% 2%; height: 190px; background-color: #F4F5F9;">
			        		<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">평가 방법 (Grading Policy) </span><br/>
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 6%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">중간고사 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="midReflectPer" name="midReflectPer" disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">기말고사 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="finalReflectPer" name="finalReflectPer" disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">출석 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="attendReflectPer" name="attendReflectPer" disabled="disabled">  
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">과제 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="assignRelectPer" name="assignRelectPer" disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">퀴즈 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="quizReflectPer" name="quizReflectPer" disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">토론 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" name="debateReflectPer" id="debateReflectPer"  disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 6%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">기타 </span>
					   		    <input class="okModify" type="text" numberOnly plusResult maxlength="2" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px; background-color: #F1F2F8;" id="otherReflectPer" name="otherReflectPer" disabled="disabled"> 
				  		    </div> 
			        		<div style="float: left; width: 15%; margin:1% 0% 0% 0%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">합계 </span>
					   		    <input type="text" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 30%; margin: 6px; padding-left: 8px;" value="100" disabled="disabled" id="resultPlus"><span style="font-weight: bold;">%</span> 
				  		    </div> 
			        </div>
			        <br/>
			        <div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 2% 2%; height: 120px; background-color: #F4F5F9;">
			        		<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">교재 및 참고서 </span><br/>
			        		<div style="float: left; width: 40%; margin:1% 0% 0% 6%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">주교재 </span>
					   		    <input class="okModify" type="text" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 80%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" disabled="disabled" id="mainTxtb" name="mainTxtb" > 
				  		    </div> 		
			        		<div style="float: left; width: 40%; margin:1% 0% 0% 6%;">
					   		    <img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold;">부교재 </span>
					   		    <input class="okModify" type="text" style="border-radius:6px; border: 1px solid gray; height: 35px; width: 80%; margin: 6px; padding-left: 12px; background-color: #F1F2F8;" disabled="disabled" id="secTxtb" name="secTxtb" > 
				  		    </div> 		
		        	</div>
		        	<br/>
		        	<div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 2% 2%; height: 100%; background-color: #F4F5F9;">
		        		<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">수업 내용</span><br/>
		        		<br/>
			        		<table class="modalTable" style="width: 99%; margin: 6px;">
					          	<tr>
					          		<th>주</th>
					          		<th>수업 주제</th>
					          	</tr>
					          	
					          	<tr>
					          		<td>1</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w1LectPlan" name="w1LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>2</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w2LectPlan" name="w2LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>3</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w3LectPlan" name="w3LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>4</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w4LectPlan" name="w4LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>5</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w5LectPlan" name="w5LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>6</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w6LectPlan" name="w6LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>7</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w7LectPlan" name="w7LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>8</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w8LectPlan" name="w8LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>9</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w9LectPlan" name="w9LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>10</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w10LectPlan" name="w10LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>11</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w11LectPlan" name="w11LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>12</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w12LectPlan" name="w12LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>13</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w13LectPlan" name="w13LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>14</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w14LectPlan" name="w14LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>15</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w15LectPlan" name="w15LectPlan"></textarea></td>
					          	</tr>
					          	<tr>
					          		<td>16</td>
					          		<td style="width: 90%;"><textarea class="okModify" rows="3" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 92%; margin: 20px 15px 15px 15px; resize: none; padding: 12px;" id="w16LectPlan" name="w16LectPlan"></textarea></td>
					          	</tr>
					          
			          		</table>
		        	</div>
		        	<br/>
		        	<div class="printDiv" style="border-radius: 10px; border:1px solid gray; padding: 15px 2% 1% 2%; height: 220px; background-color: #F4F5F9;">
			       			<img alt="mainlogo" src="/resources/img/buttonImg.PNG" ><span style="font-weight: bold; color: black;">기타 사항</span><br/>
			       			<textarea class="okModify" rows="5" cols="33" disabled="disabled" style="background-color: #F1F2F8; border-radius:5px; border: 1px solid gray; width: 99%; margin: 6px 6px 6px 6px; resize: none; padding: 12px;" id="otherthings" name="otherthings"></textarea>
		          	</div>
          		</div>
          	
	          	<br/>
	          	
				<button type="button" class="btn btn-secondary" data-dismiss="modal" >나가기</button>
				
	      </div>
	    </div>
	  </div>
	 </div>
	
	<!--강의 계획서 Modal 끝 -->
	
</div>