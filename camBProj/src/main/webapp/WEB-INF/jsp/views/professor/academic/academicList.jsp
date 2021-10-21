<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div class="card shadow mb-4" style="width: 98%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/academic/academicList'">승인 관리</h6>
		</div>
		<div style="border-radius: 15px; background-color: #F4F5F9; width: 80%; height: 150px; margin: 50px 0px 20px 150px; padding: 65px 65px 65px 300px;">
			학번&nbsp; <input type="text" >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;학생명&nbsp; <input type="text" >&nbsp;&nbsp;
			<a href="#" class="btn btn-secondary btn-icon-split" style="height:32px; ">
                <span class="text" style="padding-top: 4px;">검색</span>
            </a>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 99%">
					<div class="row">
						<div class="col-sm-12 col-md-6">
							<div class="dataTables_length" id="dataTable_length">
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<thead>
									<tr role="row">
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											학번
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											학생이름
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											학과
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											학적 변경 유형
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											신청 일자
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											승인 일자
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											승인 여부
										</th>
									</tr>
								</thead>
								
								<tbody>
									<tr>								
										<td>20151026</td>									
										<td>김지수</td>									
										<td>멀티미디어공학전공</td>									
										<td>전과</td>									
										<td>2021/09/04</td>									
										<td></td>																		
										<td>대기중</td>									
									</tr>
									<tr>									
										<td>20150947</td>
										<td>이석호</td>									
										<td>미디어영상학과</td>									
										<td>편입</td>									
										<td>2021/08/27</td>									
										<td>2021/08/28</td>									
										<td>완료</td>																		
									</tr>
									<tr>
										<td>20140909</td>									
										<td>오수연</td>									
										<td>멀티미디어공학전공</td>									
										<td>전과</td>
										<td>2021/08/15</td>									
										<td></td>										
										<td>대기</td>																		
									</tr>
									<tr>		
										<td>20180926</td>						
										<td>권수연</td>									
										<td>멀티미디어공학전공</td>									
										<td>편입</td>	
										<td>2021/08/15</td>									
										<td></td>									
										<td>대기</td>																		
									</tr>
									<tr>
										<td>20120947</td>									
										<td>최소은</td>									
										<td>항공서비스학과</td>		
										<td>편입</td>							
										<td>2021/08/13</td>
										<td>2021/08/14</td>					
										<td>완료</td>																		
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-5">

						</div>
						<div class="col-sm-12 col-md-7">
							<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
								<ul class="pagination">
									<li class="paginate_button page-item previous disabled" id="dataTable_previous">
										<a href="#" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
									</li>
									<li class="paginate_button page-item active">
										<a href="#" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">1</a>
									</li>
									<li class="paginate_button page-item ">
										<a href="#" aria-controls="dataTable" data-dt-idx="2" tabindex="0" class="page-link">2</a>
									</li>
									<li class="paginate_button page-item ">
										<a href="#" aria-controls="dataTable" data-dt-idx="3" tabindex="0" class="page-link">3</a>
									</li>
									<li class="paginate_button page-item ">
										<a href="#" aria-controls="dataTable" data-dt-idx="4" tabindex="0" class="page-link">4</a>
									</li>
									<li class="paginate_button page-item ">
										<a href="#" aria-controls="dataTable" data-dt-idx="5" tabindex="0" class="page-link">5</a>
									</li>
									<li class="paginate_button page-item next" id="dataTable_next">
										<a href="#" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
									</li>
								</ul>
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>		
	</div>

</body>
</html>