<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div class="card shadow mb-4" style="width: 98%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/salary/salaryList'">급여 관리</h6>
		</div>
		<div style="border-radius: 15px; background-color: #F4F5F9; width: 80%; height: 150px; margin: 50px 0px 20px 150px; padding: 65px 65px 65px 300px;">

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				년도 :
					<select>
						<option>-- 년도 --</option>
						<option>2021</option>
						<option>2020</option>
						<option>2019</option>
					</select>&nbsp;&nbsp;
				학기 :
					<select>
						<option>-- 월 --</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>&nbsp;&nbsp;
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
							<table style="width: 60%; margin-left: 20%;" class="table table-bordered dataTable" id="dataTable" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<thead style="text-align: center;">
									<tr role="row">
										<th style="width: 15%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											년도
										</th>
										<th style="width: 10%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											월
										</th>
										<th style="width: 20%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											교수명
										</th>
										<th style="width: 10%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											급여
										</th>
										<th style="width: 10%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											지급 일자
										</th>
										<th style="width: 10%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											지급은행
										</th>
										<th style="width: 10%;" class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 88px;">
											상세
										</th>
									</tr>
								</thead>
								
								<tbody style="text-align: center;">
									<tr>								
										<td>2021</td>									
										<td>6</td>									
										<td>박병주</td>							
										<td>7,000,000</td>							
										<td>2021/06/01</td>							
										<td>국민은행</td>							
										<td><input type="button" value="보기" onclick="javascript:location.href='/professor/study/lectureEvaluationDetail'"> </td>																		
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-5">

						</div>
					</div>		
				</div>
			</div>
		</div>		
	</div>

</body>
</html>