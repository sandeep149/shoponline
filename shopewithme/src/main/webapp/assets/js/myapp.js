$(function (){
	// solving the active menu problem
	switch (menu) 
	{
	case 'About us':
		$('#about').addClass('active');		
		break;
	case 'Contact us':
		$('#contact').addClass('active');		
		break;
	case 'All products':
		$('#listproducts').addClass('active');		
		break;
	case 'Manage products':
		$('#manageproducts').addClass('active');		
		break;
	default:
		if(menu == "Home") break;
		$('#listproducts').addClass('active');		
		$('#a_'+menu).addClass('active');
		break;
	}
	
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	
	var header = $('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length > 0){
		// set the token header for the ajax request
		
		$(document).ajaxSend(function(e, xhr, option) {
			xhr.setRequestHeader(header,token);
		})
	}
	
	
	
	
	// code for jquery data table
		
	 var $table = $('#productListTable');					
			 
	 	// execue the below code only we have this table
	 	if($table.length){
	 		// console.log('Inside the table');
	 		 
	 		var jsonUrl = '';
	 			if(window.categoryId == '')
	 				{
	 				jsonUrl = window.contextRoot +'/json/data/all/products';
	 				}
	 			else {
	 				jsonUrl = window.contextRoot +'/json/data/category/'+ window.categoryId +'/products';
				}
	 		$table.dataTable({ 
	 			
	 			lengthMmenu: [[3,5,19,-1], ['3 records','5 records','10 records','all']],
	 			pagelength: 5,
	 			ajax : {
	 				url : jsonUrl,
	 				dataSrc :''
	 			},
	 			columns : [
	 					{
	 						data : 'code',
	 						mRender(data, type, row){
	 							return '<img src= "'+window.contextRoot+'/resources/images/'+data+'.jpg" class= "dataTableImg"/>';
	 						}
	 					},
	 					{
	 						data:'name'
	 					},
	 					{
	 						data:'brand'
	 					},
	 					{
	 						data:'unitPrice',
	 						mRender : function (data, type, row) {
								return '&#8377; '+ data
							}
	 					},
	 					{
	 						data:'quantity',
	 						mRender : function(data, type, row){
	 							if(data<1){
	 								return '<span style="color:red">Out of Stock!</span>'
	 							}
	 							return data;
	 						}
	 							
	 					},
	 					{
	 						data:'id',
	 						bSortable:false,
	 						mRender : function(data, type, row){
	 							var str= '';
	 							str += '<a href= "'+window.contextRoot +'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

	 							if(row.quantity < 1){
	 								
	 								str += '<a href="javascript:void(0)"  class= "btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
	 							}
	 							else{
	 								
	 							}
	 							
	 							str += '<a href= "'+window.contextRoot +'/cart/add/'+data+'/product" class= "btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
	 						
	 							return str;
	 						}
	 						
	 					}
	 					
	 					]
	 			
	 			 		});
	 	}	
  //------------------------		 	
	 	
	 	
	 	//---------------------
	 	// data table for admin
	 	//
	 	
		 var $adminProductsTable = $('#adminProductsTable');					
		 
		 	// execue the below code only we have this table
		 	if($adminProductsTable.length){
		 		// console.log('Inside the table');
		 		 
		 		var jsonUrl = window.contextRoot +'/json/data/admin/all/products';
		 			 
		 		
		 		$adminProductsTable.dataTable({ 
		 			
		 			lengthMmenu: [[10, 30, 50, -1], ['10 records','30 records','50 records','all']],
		 			pagelength: 30,
		 			ajax : {
		 				url : jsonUrl,
		 				dataSrc :''
		 			},
		 			columns : [
		 					{
		 						data : 'id'
		 					},	
		 					{		 					
		 						data : 'code',
		 						bSortable : false,
		 						mRender: function(data, type, row){
		 							return '<img src= "'+window.contextRoot+'/resources/images/'+data+'.jpg" class= "adminDataTableImg"/>';
		 						}
		 					},
		 					{
		 						data:'name'
		 					},
		 					{
		 						data:'brand'
		 					},
		 					
		 					{
		 						data:'quantity',
		 						mRender : function(data, type, row){
		 							if(data<1){
		 								return '<span style="color:red">Out of Stock!</span>'
		 							}
		 							return data;
		 						}
		 							
		 					},
		 					{
		 						data:'unitPrice',
		 						mRender : function (data, type, row) {
									return '&#8377; '+ data
								}
		 					},
		 					{
		 						data: 'active',
		 						bSortable: false,
		 						mRender : function(data,type,row){
		 							var str = '';
		 							
		 							str += '<label class="switch">';
		 							if(data){
		 								str +=	'<input	type="checkbox" checked="checked" value="'+row.id+'" />';
		 							}
		 							else {
		 								str +=	'<input	type="checkbox" value="'+row.id+'" />';
									}
										
		 							str += '<div class="slider"></div> </label>';
		 							
		 							return str;
		 						}
		 					},
		 					{
		 						data:'id',
		 						bSortable: false,
		 						mRender : function (data,type,row){
		 							var str = '';
		 							str +='<a href="'+window.contextRoot+'/manage/'+data+'/product"	class="btn btn-warning">';
		 							str += '<span class="glyphicon glyphicon-pencil"></span> </a>';
		 							 return str;
		 						}
		 					}
		 					],
		 				initComplete: function(){
		 					var api = this.api();
		 					api.$('.switch input[type = "checkbox"]').on('change', function(){
		 				 		var checkbox = $(this);
		 				 		var checked = checkbox.prop('checked');
		 				 		var dMsg = (checked)? 'You want to active the product ?':
		 				 							  'you want to deactivte the product ?';
		 				 		var value = checkbox.prop('value');
		 				 		
		 				 		bootbox.confirm({
		 				 			size :'medium',
		 				 			title : 'product Activation and deactivation',
		 				 			message : dMsg,
		 				 			
		 				 			callback: function(confirmed){
		 				 				if(confirmed){
		 				 					console.log(value);
		 				 					
		 				 					var activationUrl = window.contextRoot + '/manage/product/' + value +'/activation';
		 				 					$.post(activationUrl, function(data) {
		 				 						bootbox.alert({
			 				 						size : 'medium',
			 				 						title : 'information',
			 				 						message: data
			 				 					});
											});
		 				 					
		 				 				}
		 				 				else {
		 									checkbox.prop('checked', !checked);
		 								}
		 				 			}
		 				  		});
		 				 	});
		 				}	
		 			
		 			 		});
		 	}	
	 	 
		 	//---------------------
	//validation code for category
		 	
		 	var $categoryForm = $('#categoryForm')
		 	
		 	if($categoryForm.length){
		 		 $categoryForm.validate({
		 			 rules: {
		 				 name : {
		 					 required : true,
		 					 minlength : 2,
		 				 },
		 				 description:{
		 					 required : true
		 				 }
		 			 },
		 			 messages : {
		 				 name : {
		 					 required : 'Please add the Category name!',
		 					 minlength : 'the category name should not be less the 2 charcter '
		 				 },
		 				 
		 			 	description : {
		 			 		required : 'please add a description for this category!'
		 			 	}
		 			 },
		 			 
		 			 errorElement : 'em',
		 			 errorPlacement : function( error, element){
		 				 //add classs of help block
		 				 error.addClass('help-block');
		 				 // add the error element after the inpute element  
		 				 error.insertAfter(element);
		 			 }
		 		 });
		 	}
		//-----------------------
		 	
//validation code for login form
		 	
		 	var $loginForm = $('#loginForm')
		 	
		 	if($loginForm.length){
		 		 $loginForm.validate({
		 			 rules: {
		 				 username : {
		 					 required : true,
		 					 email : true
		 				 },
		 				 password:{
		 					 required : true
		 				 }
		 			 },
		 			 messages : {
		 				 username : {
		 					 required : 'Please enter the username!',
		 					 email : 'please enter valid email address !'
		 				 },
		 				 
		 			 	password : {
		 			 		required : 'please enter valid paswword !'
		 			 	}
		 			 },
		 			 
		 			 errorElement : 'em',
		 			 errorPlacement : function( error, element){
		 				 //add classs of help block
		 				 error.addClass('help-block');
		 				 // add the error element after the inpute element  
		 				 error.insertAfter(element);
		 			 }
		 		 });
		 	}
		 	
}); 