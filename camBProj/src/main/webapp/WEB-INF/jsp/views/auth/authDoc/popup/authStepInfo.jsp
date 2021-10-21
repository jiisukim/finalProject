<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div id="body">
<!-- Modal -->
	  <div class="modal fade bd-example-modal-xl" id="authStepInfo" role="dialog"  data-backdrop="static"> <!-- 사용자 지정 부분① : id명 -->
	    <div class="modal-dialog modal-xl">
	      <!-- Modal content-->
	      <div class="modal-content" style="border-radius:20px 20px 8px 8px !important;">
				
				<div class="modal-header" style="background-color: #364085; border-radius: 8px 8px 0px 0px !important;">
					<p class="modal-title" style="color: white; font-weight: bold;">강의 평가</p>
					<button type="button" class="close" data-dismiss="modal" style="color: white;">×</button>
				</div>
				<div class="modal-body" id="stepInfo">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal" >닫기</button>
				</div>
	      </div>
	    </div>
	  </div>
 </div>
