<!DOCTYPE HTML>
<%@ page import="java.util.List" %>
<%@ page import="edu.mssm.pharm.maayanlab.Harmonizome.net.URLCodec" %>
<%@ page import="edu.mssm.pharm.maayanlab.Harmonizome.model.Dataset" %>
<html>
	<head>
		<%@include file="globalIncludes.html" %>
		<%@include file="commonIncludes.html" %>
		<script>
			$(function() {
				HMZ();
			});
		</script>
	</head>
	<body>
		<%@include file="navbar.html"%>
		<div class="wrapper">
			<div class="content container browse">
				<h1>Datasets</h1>
				<p class="instruction">Sort the table below clicking on the headers or type in the search bar.</p>
				<table class="table data-table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Resource</th>
							<th>Description</th>
							<th>Category</th>
							<th>Attribute</th>
							<th>Downloads</th>
							<th>Views</th>
				    	</tr>
					</thead>
					<tbody>
					<% @SuppressWarnings("unchecked")
					List<Dataset> datasets = (List<Dataset>) request.getAttribute("datasets");
					for (int i = 0; i < datasets.size(); i++) { %>
						<% Dataset dataset = datasets.get(i); %>
						<tr>
							<td><%= dataset.getName() %></td>
							<td>
								<a href="resource/<%= URLCodec.encode(dataset.getResource().getName()) %>">
									<%= dataset.getResource().getName() %>
								</a>
							</td>
							<td><%= dataset.getDescription() %></td>
							<td><%= dataset.getDatasetGroup().getName() %></td>
							<td><%= dataset.getAttributeType().getName() %></td>
							<td>
								<%-- <a href="dataset/<%= URLCodec.encode(dataset.getName()) %>" type="button" class="btn btn-default download" aria-label="Left Align">
									<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
					            </a>--%>
				            </td>
				            <td><%= dataset.getNumPageViews() %></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</div>
			<%@include file="footer.html"%>
		</div>
	</body>
</html>