$(document).ready(function() {
	    // Hàm thêm đoạn mã HTML vào form
	    var sida = $('.sd-may').length;
	    function addSDMay() {
	    	console.log(sida)
	        var newSDMayHTML = `
	            <div class="sd-may row p-0">
	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Mã Máy</label>
	                       <select name="listMay[${sida}].maMay" class="form-select">
	                           <option value="" disabled="true" selected="true">Chọn ID May</option>
	                           <c:forEach items="${listMM}" var="item">
	                               <option value="${item}">${item}</option>
	                           </c:forEach>
	                       </select>
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Ngày SD:</label>
	                       <input type="date" id="ngaySD_${sida}" class="form-control" name="listMay[${sida}].ngaySD" />
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Giờ SD:</label>
	                       <input type="time" id="gioSD_${sida}" class="form-control" name="listMay[${sida}].gioSD" />
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">TG SD:</label>
	                       <input type="number" id="thoiGianSD_${sida}" class="form-control" name="listMay[${sida}].thoiGianSD" />
	                   </div>
	               </div>
	           </div> `;

	        $('#render').append(newSDMayHTML); // Thêm đoạn mã HTML vào container
	        sida ++;
	    }
	    
	    $('#addMay').click(function() {
	    	addSDMay();
	    });
	});