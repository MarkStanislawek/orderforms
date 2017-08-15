<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<#assign lastUpdate = .now>
<title>Manna Order Form - revised ${lastUpdate?date}</title>

<style type="text/css">

body { font-family: "Times New Roman", Serif;}

table {
	border-collapse: collapse;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	text-align: left;
}

th {
	text-align: center;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.center {
	text-align: center;
}

.bold {
	font-weight: bold;
}

.bold-underlined {
	font-weight: bold;
	text-decoration: underline;
}

.large {
	font-size: large;
}

.x-large {
	font-size: x-large;
}

@media print {
	@page { margin: 0; }
	#header, #footer { display: none !important; }
    body { font-size: 70%; margin: 0; }
    table { page-break-inside: avoid; }
  	p { page-break-before: always; }
}

</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="10" class="x-large bold center">St. Gerald Manna Order Form</td>
		</tr>
		<tr>
			<td class="bold" colspan="5">Who receives the credit?</td>
			<td class="bold" colspan="5">Order Date:</td>
		</tr>
		<tr>
			<td class="large bold" colspan="5">Name:</td>
			<td class="large bold" colspan="5">Phone Number:</td>
		</tr>
		<tr>
			<th width="20%">IN STOCK VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br>Value
			</th>
			<th width="7.5%">Total $<br>Amt.</th>
			<th width="7.5%">Tuition<br>Credit
			</th>
			<th width="20%">IN STOCK VENDORS</th>
			<th class="center" width="7.5%">%</th>
			<th class="center" width="7.5%">Card<br>Value
			</th>
			<th width="7.5%">Total $<br>Amt.</th>
			<th width="7.5%">Tuition<br>Credit
			</th>
		</tr>
		<#list onhandProducts as product> 
			${product?item_cycle('<tr>','')}
			<td>${product.name}</td>
			<td class="center">${product.tuitionCreditPercentage}</td>
			<td class="center">${product.faceValue}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td> 
			${product?item_cycle('','</tr>')}
		</#list>
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
	<p>
	<table>
	<tr>
			<td colspan="10" class="x-large bold center">Backorder Vendors</td>
	</tr>
	<tr>
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br>Value
			</th>
			<th width="7.5%">Total $<br>Amt.</th>
			<th width="7.5%">Tuition<br>Credit
			</th>
			<th width="20%">BACKORDER VENDORS</th>
			<th width="7.5%">%</th>
			<th width="7.5%">Card<br>Value
			</th>
			<th width="7.5%">Total $<br>Amt.</th>
			<th width="7.5%">Tuition<br>Credit
			</th>
		</tr>
		<#list backorderProducts as backorderProduct> 
			${backorderProduct?item_cycle('<tr>','')}
			<td>${backorderProduct.name}</td>
			<td class="center">${backorderProduct.tuitionCreditPercentage}</td>
			<td class="center">${backorderProduct.faceValue}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td> 
			${backorderProduct?item_cycle('','</tr>')}
		</#list>
		<tr>
			<td class="bold" colspan="10">Many more vendors are available, if you don't see what you need, PLEASE call the Development Office at 708-422-2194.</td>
		</tr>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>BACKORDER TOTAL:</b><br>(Write on front side of form.)</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5"><b>TUITION REIMBURSEMENT:</b><br>(Add to total on front side.)</td>
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
	</table>
</body>
</html>