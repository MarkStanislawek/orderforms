<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<#assign lastUpdate = .now>
<title>Manna Order Form - revised ${lastUpdate?date}</title>
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
			<td colspan="10" class="x-large-center">ST. GERALD MANNA ORDER FORM</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td class="bold" colspan="5">WHO RECEIVES THE CREDIT?</td>
			<td class="bold" colspan="5">ORDER DATE:</td>
		</tr>
		<tr>
			<td class="large-bold" colspan="5">NAME:</td>
			<td class="large-bold" colspan="5">PHONE NUMBER:</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<th width="20%">IN STOCK VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">CARD<br />VALUE
			</th>
			<th width="7.5%">TOTAL $<br />AMT.</th>
			<th width="7.5%">TUITION<br />CREDIT
			</th>
			<th width="20%">IN STOCK VENDORS</th>
			<th class="center" width="7.5%">%</th>
			<th class="center" width="7.5%">CARD<br />VALUE
			</th>
			<th width="7.5%">TOTAL $<br />AMT.</th>
			<th width="7.5%">TUITION<br />CREDIT
			</th>
		</tr>
		<#if onhandProducts?has_content>
			<#list onhandProducts as product> 
				${product?item_cycle('<tr>','','<tr style="background-color: #d9d9d9">','')}
				<td>${product.name}</td>
				<td class="center">${product.tuitionCreditPercentage}</td>
				<td class="center">${product.faceValue}</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td> 
				${product?item_cycle('','</tr>')}
				<#if product?is_last>
					<#if product?is_odd_item>
						</tr>
					</#if>
				</#if>
			</#list>
		</#if>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td class="bold" colspan="5">PLEASE FILL IN:</td>
			<td class="bold" colspan="5">SIDE 1 TOTAL:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">HOLD:</td>
			<td class="bold" colspan="5">BACKORDER TOTAL:</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td class="bold" colspan="5">SEND W/STUDENT:</td>
			<td class="bold" colspan="5">TOTAL SALE:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">ROOM #:</td>
			<td class="bold" colspan="5">TUITION REIMBURSEMENT:</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="5">CASH AMT.:</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="2">CHECK #:</td>
			<td class="bold" colspan="3">AMT.:</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="5">NAME ON CHECK:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">*Kohls is the only vendor that accepts gift cards as payment on your charge.</td>
			<td class="bold" colspan="5">Please make checks payable to: St. Gerald Manna</td>
		</tr>
		<tr style="background-color: #d9d9d9">
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td class="bold" colspan="10">Seller's initials:</td>
		</tr>
	</table>
</body>
</html>