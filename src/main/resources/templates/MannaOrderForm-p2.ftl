<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<#assign lastUpdate = .now>
<title>Manna Order Form - Back Order - revised ${lastUpdate?date}</title>
<style type="text/css">
body {
	font-family: helvetica, arial, sans-serif;
	text-rendering: optimizeLegibility;
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
			<td colspan="10" class="x-large-center">BACKORDER VENDORS</td>
	</tr>
	<tr style="background-color: #d9d9d9">
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">CARD<br />VALUE
			</th>
			<th width="7.5%">TOTAL $<br />AMT.</th>
			<th width="7.5%">TUITION<br />CREDIT
			</th>
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">CARD<br />VALUE
			</th>
			<th width="7.5%">TOTAL $<br />AMT.</th>
			<th width="7.5%">TUITION<br />CREDIT
			</th>
		</tr>
		<#if backorderProducts?has_content>
			<#list backorderProducts as backorderProduct> 
				${backorderProduct?item_cycle('<tr>','','<tr style="background-color: #d9d9d9">','')}
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
			<td class="bold" colspan="10">Many more vendors are available, if you don't see what you need, please call the Development Office at 708-422-2194.</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>BACKORDER TOTAL:</b><br />(Write on front side of form.)</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>TUITION REIMBURSEMENT:</b><br />(Add to total on front side.)</td>
		</tr>
		<tr>
			<td class="bold-underlined" colspan="10">Cash & Carry Sales Times</td>
		</tr>
		<#if saleDates?has_content>
			<#list saleDates as saleDate>
			${saleDate?item_cycle('<tr style="background-color: #d9d9d9">','<tr>')}
			<td class="bold">${saleDate.date!"&nbsp;"}</td>
			<td class="bold" colspan="2">${saleDate.time!"&nbsp;"}</td>
			<td class="bold" colspan="3">${saleDate.location!"&nbsp;"}</td>
			<td class="bold" colspan="4">${saleDate.note!"&nbsp;"}</td>
		</tr>
			</#list>
		</#if>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td class="bold" colspan="10">Back orders and special orders must be placed by December 11th to arrive before Christmas.</td>
		</tr>
		<tr>
			<td class="right-align" colspan="10">revised ${lastUpdate?date}</td>
		</tr>
	</table>
</body>
</html>