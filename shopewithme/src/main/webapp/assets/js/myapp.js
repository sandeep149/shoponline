	
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
	 			
	 			 		})
	 	}	
	 							
	 			
}); 