<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<#assign lastUpdate = .now>
<title>Manna Order Form - revised ${lastUpdate?date}</title>
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
			<td colspan="10" class="x-large-center">St. Gerald Manna Order Form</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">Who receives the credit?</td>
			<td class="bold" colspan="5">Order Date:</td>
		</tr>
		<tr>
			<td class="large-bold" colspan="5">Name:</td>
			<td class="large-bold" colspan="5">Phone Number:</td>
		</tr>
		<tr>
			<th width="20%">IN STOCK VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br />Value
			</th>
			<th width="7.5%">Total $<br />Amt.</th>
			<th width="7.5%">Tuition<br />Credit
			</th>
			<th width="20%">IN STOCK VENDORS</th>
			<th class="center" width="7.5%">%</th>
			<th class="center" width="7.5%">Card<br />Value
			</th>
			<th width="7.5%">Total $<br />Amt.</th>
			<th width="7.5%">Tuition<br />Credit
			</th>
		</tr>
		<#if onhandProducts?has_content>
			<#list onhandProducts as product> 
				${product?item_cycle('<tr>','')}
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
		<tr>
			<td class="bold" colspan="5">Please fill in:</td>
			<td class="bold" colspan="5">SIDE 1 TOTAL:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">HOLD:</td>
			<td class="bold" colspan="5">BACKORDER TOTAL:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">SEND W/STUDENT:</td>
			<td class="bold" colspan="5">TOTAL SALE:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">ROOM #:</td>
			<td class="bold" colspan="5">TUITION REIMBURSEMENT:</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="5">Cash Amt.:</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="2">Check #:</td>
			<td class="bold" colspan="3">Amt.:</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td class="bold" colspan="5">Name on check:</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">*Kohls is the only vendor that accepts gift cards as payment on your charge.</td>
			<td class="bold" colspan="5">Make checks payable to: St. Gerald Manna</td>
		</tr>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td class="bold" colspan="10">Seller's initials:</td>
		</tr>
	</table>
</body>
</html>