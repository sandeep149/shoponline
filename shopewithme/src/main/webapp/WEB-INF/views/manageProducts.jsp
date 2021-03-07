<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">
				<div class="panle-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!--form element  -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>

							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<em class="help-block">Please Enter Product Name</em>
								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								brand Name:</label>

							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product Name" class="form-control" />
								<em class="help-block">Please Enter Brand Name</em>
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="write a descripton"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price In &#8377" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity available" class="form-control" />
							</div>
						</div>

						<!-- File element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<c:if test="${product.id== 0 }">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn-btn warning btn-xm">
											Add Category</button>
									</div>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn-btn-primary" />
							</div>
						</div>

						<!-- Hidden fields  for products  -->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="purchases" />
						<sf:hidden path="active" />
						<sf:hidden path="views" />
					</sf:form>
				</div>

			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-sx-12">
			<h3>Available Products</h3>
			<hr>
		</div>

		<div class="col-sx-12">
			<div style="overflow: auto">
				<!-- Product Table for admin -->
				<table id="adminProductsTable"
					class="table table-striped table-borderd">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<!-- //tbody will be added dynamically -->
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="#myCategoryModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Modal header --> 
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!-- Category form -->
					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-lable col-md-4">Category
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="category_description" class="control-lable col-md-4">Category
								description</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5" path="description"
									id="category_description" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>

			</div>

		</div>

	</div>


</div>