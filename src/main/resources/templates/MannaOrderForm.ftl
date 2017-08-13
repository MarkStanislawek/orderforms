<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<#assign lastUpdate = .now>
<title>Manna Order Form - revised ${lastUpdate?date}</title>

<style type="text/css">

*{ font-family: Arial, sans-serif }

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

tr:hover {
	background-color: #f5f5f5
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.center {
	text-align: center;
}
</style>

</head>
<body>
	<table>
		<tr>
			<td colspan="10" class="center"><h3>St. Gerald Manna Order Form</h3></td>
		</tr>
		<tr>
			<td colspan="5">Who receives the credit?</td>
			<td colspan="5">Order Date</td>
		</tr>
		<tr>
			<td colspan="5">Name</td>
			<td colspan="5">Phone Number</td>
		</tr>
		<tr>
			<th>IN STOCK VENDORS</th>
			<th>%</th>
			<th>Card<br>Value
			</th>
			<th>Total $<br>Amt.</th>
			<th>Tuition<br>Credit
			</th>
			<th>IN STOCK VENDORS</th>
			<th>%</th>
			<th>Card<br>Value
			</th>
			<th>Total $<br>Amt.</th>
			<th>Tuition<br>Credit
			</th>
		</tr>
		<#list onhandProducts as product> 
			${product?item_cycle('<tr>','')}
			<td>${product.name}</td>
			<td>${product.tuitionCreditPercentage}</td>
			<td>${product.faceValue}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td> 
			${product?item_cycle('','</tr>')}
		</#list>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5">Please fill in:</td>
			<td colspan="5">Side 1 Total</td>
		</tr>
		<tr>
			<td colspan="5">Hold</td>
			<td colspan="5">Backorder Total</td>
		</tr>
		<tr>
			<td colspan="5">Send w/Student</td>
			<td colspan="5">Total Sale</td>
		</tr>
		<tr>
			<td colspan="5">Room #</td>
			<td colspan="5">Tuition Reimbursement</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5">Cash Amt.</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="2">Check #</td>
			<td colspan="3">Amt.</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
			<td colspan="5">Name on check:</td>
		</tr>
		<tr>
			<td colspan="5">*Kohls is the only vendor that accepts gift
				cards as payment on your charge</td>
			<td colspan="5">Make checks payable to: St. Gerald Manna</td>
		</tr>
		<tr>
			<td colspan="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="10">Seller's initials:</td>
		</tr>
	</table>
	<p style="page-break-before: always">
	<table>
	<tr>
			<th>BACKORDER VENDORS</th>
			<th>%</th>
			<th>Card<br>Value
			</th>
			<th>Total $<br>Amt.</th>
			<th>Tuition<br>Credit
			</th>
			<th>BACKORDER VENDORS</th>
			<th>%</th>
			<th>Card<br>Value
			</th>
			<th>Total $<br>Amt.</th>
			<th>Tuition<br>Credit
			</th>
		</tr>
		<#list backorderProducts as backorderProduct> 
			${backorderProduct?item_cycle('<tr>','')}
			<td>${backorderProduct.name}</td>
			<td>${backorderProduct.tuitionCreditPercentage}</td>
			<td>${backorderProduct.faceValue}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td> 
			${backorderProduct?item_cycle('','</tr>')}
		</#list>
	</table>
</body>
</html>