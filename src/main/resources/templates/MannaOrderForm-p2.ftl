<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<#assign lastUpdate = .now>
<title>Manna Order Form - Back Order - revised ${lastUpdate?date}</title>
<style type="text/css">
body {
	font-family: "Times New Roman", Serif;
	margin: 0 auto;
}

table {
	border-collapse: collapse;
	border: 1px solid black;
	text-align: left;
}

th, td {
	border: 1px solid black;
	text-align: left;
}

th {
	text-align: center;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

p { 
	page-break-before: always; 
}

.center {
	text-align: center;
}

.right-align {
	text-align: right;
}

.bold {
	font-weight: bold;
}

.bold-underlined {
	font-weight: bold;
	text-decoration: underline;
}

.large-bold {
	font-size: large;
	font-weight: bold;
}

.x-large-center {
	font-size: x-large;
	font-weight: bold;
	text-align: center;
}
</style>
</head>
<body>
	<table>
	<tr>
			<td colspan="10" class="x-large-center">Backorder Vendors</td>
	</tr>
	<tr>
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br />Value
			</th>
			<th width="7.5%">Total $<br />Amt.</th>
			<th width="7.5%">Tuition<br />Credit
			</th>
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br />Value
			</th>
			<th width="7.5%">Total $<br />Amt.</th>
			<th width="7.5%">Tuition<br />Credit
			</th>
		</tr>
		<#if backorderProducts?has_content>
			<#list backorderProducts as backorderProduct> 
				${backorderProduct?item_cycle('<tr>','')}
				<td>${backorderProduct.name}</td>
				<td class="center">${backorderProduct.tuitionCreditPercentage}</td>
				<td class="center">${backorderProduct.faceValue}</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td> 
				${backorderProduct?item_cycle('','</tr>')}
				<#if backorderProduct?is_last>
					<#if backorderProduct?is_odd_item>
						</tr>
					</#if>
				</#if>
			</#list>
		</#if>
		<tr>
			<td class="bold" colspan="10">Many more vendors are available, if you don't see what you need, PLEASE call the Development Office at 708-422-2194.</td>
		</tr>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>BACKORDER TOTAL:</b><br />(Write on front side of form.)</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>TUITION REIMBURSEMENT:</b><br />(Add to total on front side.)</td>
		</tr>
		<tr>
			<td class="bold-underlined" colspan="10">CASH & CARRY SALES TIMES</td>
		</tr>
		<tr>
			<td class="bold">Thursday</td>
			<td class="bold" colspan="2">6:00 - 7:30pm</td>
			<td class="bold" colspan="3">1st Floor Development Office Enter Door #10</td>
			<td class="bold" colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td class="bold">Friday</td>
			<td class="bold" colspan="2">8:00am - 9:30am</td>
			<td class="bold" colspan="3">1st Floor Development Office Enter Door #10</td>
			<td class="bold" colspan="4">June 9 to Aug. 25, Friday hours are 9 to 1030 am</td>
		</tr>
		<tr>
			<td class="bold">Third Sunday of the month</td>
			<td class="bold" colspan="2">9am - noon</td>
			<td class="bold" colspan="3">Room 119</td>
			<td class="bold" colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td class="bold" colspan="10">Our Orders are placed on Monday afternoon. Please give us your order by 10 am Monday. Thank you!!</td>
		</tr>
		<tr>
			<td class="right-align" colspan="10">revised ${lastUpdate?date}</td>
		</tr>
	</table>
</body>
</html>