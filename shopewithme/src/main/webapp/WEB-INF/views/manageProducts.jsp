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
					<sf:form class="form-horizontal" modelAttribute="product">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>

							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
									 <em class="help-block">Please Enter Product Name</em>
								<sf:errors path="name" cssClass="help-block" element="em"/>
									
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								brand Name:</label>

							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product Name" class="form-control" /> 
									<em	class="help-block">Please Enter Brand Name</em>
									<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="description">Product
									Description</label>
								<div class="col-md-8">
									<sf:textarea path="description" id="description" rows="4"
										placeholder="write a descripton"></sf:textarea>
										<sf:errors path="description" cssClass="help-block" element="em"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="unitPrice">Enter
									Unit Price:</label>
								<div class="col-md-8">
									<sf:input type="number" path="unitPrice" id="unitPrice"
										placeholder="Unit Price In &#8377" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
										
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="quantity">Quantity
									Available</label>
								<div class="col-md-8">
									<sf:input type="number" path="quantity" id="quantity"
										placeholder="Quantity available" class="form-control"/>
								</div> 
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="categoryId">Select Category:</label>
								<div class="col-md-8">
									<sf:select class="form control" id="categoryId" path="categoryId"
											items="${categories}"	
											itemLabel="name"
											itemValue="id"/>
								</div>
							</div>
							<div class="form-group">

								<div class="col-md-offset-4 col-md-8">
									<input type="submit" name="submit" id="submit" value="Submit"
										class="btn-btn-primary" />
								</div>
							</div>
							<!-- Hidden fields  for products  -->
							<sf:hidden path="id"/>
							<sf:hidden path="code"/>
							<sf:hidden path="supplierId"/>
							<sf:hidden path="purchases"/>
							<sf:hidden path="active"/>
							<sf:hidden path="views"/>	
					</sf:form>
				</div>

			</div>
		</div>
	</div>
</div>