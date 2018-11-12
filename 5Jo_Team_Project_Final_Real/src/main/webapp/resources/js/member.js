	$(function(){
	/*	$('#logout__btn').hide();
		$('#map__btn').hide();*/
		
		$('#join__btn').on('click', joinForm);
		$('#login__btn').on('click', loginForm);
		$('#map__btn').on('click', mapWindow);
		$('#logout__btn').on('click', logout);
	})
	var count = 0;
	var countA = 0;
	function joinForm(){		
		count++;
		if(count%2!=0){
			$('#trigger').click();
			$('#login__btn').hide(500);
			var output="";
			
			output +='<div class="grid">';
			output +='<div id="login">'
			output +='<div class="join__form">';
			output +='<h2><span class="fontawesome-lock"></span>会員登録</h2>';
			output +='<div class="checkAccount"></div>';
			output +='<form method="post" action="join" class="join_form">';
			output +='<fieldset>';
			output +='<input type="hidden" name="address" class="address"/>';
			output +='<p><label>アカウント</label></p>';
			output +='<input type="text" name="userId" class="userid" placeholder="アカウント" /><br />';
			output +='<p><label>名前</label></p>';
			output +='<input type="text" name="userName" class="username" placeholder="名前" /><br />';
			output +='<p><label>パスワード</label></p>';
			output +='<input type="password" name="userPwd" class="userpwd" placeholder="パスワード" /><br />';
			output +='<p><label>パスワード確認</label></p>';
			output +='<input type="password" class="userpwd2" placeholder="パスワード確認" /><br />';
			output +='<p><label>性別</label></p>';
			output +='<div class="gender__radio">'
			output +='<input type="radio" name="gender" class="gender" value="male"/>男性';
			output +='<input type="radio" name="gender" class="gender" value="female"/>女性<br>';
			output +='</div>'
			output +='<p><label for="userId">生年月日</label></p>';
			output +='<input type="text" name="birth" class="birthday" placeholder="生年月日" /><br/>';
			output +='<p><label for="userId">E-Mail</label></p>';
			output +='<input type="text" name="emailAccount" class="emailAccount" placeholder="E-Mailアカウント" style="width: 328px;"/>＠<input type="text" name="emailDomain" class="emailDomain" placeholder="E-Mailドメイン" style="width: 328px;"/><br/>';
			output +='<p><label for="userId">郵便番号</label></p>';
			output +='<input type="text" class="zip" placeholder="郵便番号" style="width: 340px;"/><input type="button" class="addressSearch" value="住所を自動で入力する" style="width: 340px;height: 40px;"/>';
			output +='<p><label for="userId">住所</label></p>';
			output +='<input readonly type="text" class="state" placeholder="都道府県" style="width: 340px;"/><input readonly type="text" class="city" placeholder="市区町村" style="width: 340px;"/>';
			output +='<input readonly type="text" class="address1" placeholder="番地" style="width: 340px;"/><input type="text" class="address2" placeholder="建物名・階・部屋番号" style="width: 340px;"/>';
			output +='<input type="button" class="joinButton" value="JOIN" />';
			output +='<input type="reset" class="" value="キャンセル">';
			output +='</form>';
			output +='</div>';
			output +='<h3></h3>';
			output +='</div>';
			output +='</div>';
			
			$('.related').html(output);
			
			$('.userid').on('keyup', idCheck);
			$('.userpwd').on('keyup', pwdCheck);
			$('.userpwd2').on('keyup', pwd2Check);
			$('.addressSearch').on('click', setState);
			$('.joinButton').on('click', join);
		} if(count%2==0){
			$('#trigger').click();
			$('.related').html("");
			$('#login__btn').show(500);
		}
	}
	
function join(){		
		var username = $('.username').val();
		var userpwd = $('.userpwd').val();
		var userid = $('.userid').val();
		var gender = $('.gender').val();
		var birth = $('.birthday').val();
		var address = $('.zip').val()+$('.state').val()+$('.city').val()+$('.address1').val()+$('.address2').val();
		var emailAccount = $('.emailAccount').val();
		var emailDomain = $('.emailDomain').val();
		
		var data = {"userName" : username,
							 "userPwd" : userpwd,
							 "userId" : userid,
							 "gender" : gender,
							 "birth" : birth,
							 "address" : address,
							 "emailAccount" : emailAccount,
							 "emailDomain" : emailDomain
							};
		$.ajax({
			method : 'post',
			url : 'join',
			data : JSON.stringify(data),
			dataType : 'text',
			contentType : 'application/json; charset=UTF-8 ',
			success : function(res){
					if(res == 1){
						alert("会員登録完了");
						count++;
						$('#trigger').click();
						$('.related').html("");
						$('#login__btn').show(500);	
					}
			}
		})
		}
	
	function loginForm(){
		countA++;		
		if(countA%2!=0){
			$('#trigger').click();
			$('#join__btn').hide(500);
			var output="";
			output +='<div class="grid">';
			output +='<div id="login">'
			output +='<div class="login__form">';
			output +='<h2><span class="fontawesome-lock"></span>ログイン</h2>';
			output +='<div class="checkAccount"></div>';
			output +='<form method="post" action="join" class="login_form">';
			output +='<fieldset>';
			output +='<p><label>アカウント</label></p>';
			output +='<input type="text" name="userId" class="loginId" placeholder="アカウント" /><br />';
			output +='<p><label>パスワード</label></p>';
			output +='<input type="password" name="userPwd" class="loginPwd" placeholder="パスワード" /><br />';
			output +='<input type="button" class="loginButton" value="LOGIN" />';
			output +='</form>';
			output +='</div>';
			output +='<h3></h3>';
			output +='</div>';
			output +='</div>';
			
			$('.related').html(output);
			$('.loginButton').on('click', doLogin);
		} if(countA%2==0){
			$('#trigger').click();
			$('.related').html("");
			$('#join__btn').show(500);
		}		
	}
	
	function doLogin(){
		var userId = $('.loginId').val();
		var userPwd = $('.loginPwd').val();
		
		var data = {"userId" : userId, "userPwd" : userPwd}
		$.ajax({
			method : 'post',
			url : 'login',
			data : JSON.stringify(data),
			dataType : 'text',
			contentType : 'application/json; charset:utf-8;',
			success : function(res){
				if(res==1){
					count++;
					
					$('#trigger').click();
					$('.related').html("");
					$('#home_btn').click();
					/*$('#login__btn').hide(500);
					$('#logout__btn').show(500);
					$('#map__btn').show(500);
					$('#logout__btn').on('click', logout);*/
				}
				if(res==0){
					alert("メールの認証をしてください。");					
				}
			}
		})
	}
	
	function idCheck(){
		var userId = $('.userid').val();
		if(userId.length<3 || userId.length>10){
			$('.checkAccount').text("アカウントは3~10文字内でご入力してください。");
			return;
		}
		else if(/^(?=.*[!@#$%^*+=-])/.test(userId)){
			$('.checkAccount').text("特殊記号は使うことができません。");
			return;
		}

		$.ajax({
			method : 'get',
			url : 'idCheck',
			data : 'userId='+userId,
			dataType : 'text',
			contentType : 'application/json; charset:utf-8',
			success : function(res){
				if(res==0){
					$('.checkAccount').text("使用可能なIDです。");
				} else if(res==1){
					$('.checkAccount').text("既に使われているIDです。");
					return;
				}
			}
		})
	}
	
	function pwdCheck(){
		var userId = $('.userid').val();
		var userPwd = $('.userpwd').val();
		
		var checkNumber = userPwd.search(/[0-9]/g);
		var checkEnglish = userPwd.search(/[a-z]/ig);
		
		if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(userPwd)){
			$('.checkAccount').text("英数字や特殊記号を合わせて8桁以上にしてください。");
			return;
		}
		else if(checkNumber <0 || checkEnglish <0){
			$('.checkAccount').text("英数字と特殊記号を合わせてください。");
			return;
		}
		else if(userId.indexOf(userPwd)>-1){
			$('.checkAccount').text("パスワードにIDを使うことはできません。");
			return;
		}
		else{
			$('.checkAccount').text("適切なパスワード。");
		}
	}
	
	function pwd2Check(){
		var userPwd = $('.userpwd').val();
		var userPwd2 = $('.userpwd2').val();
		
		if(userPwd != userPwd2){
			$('.checkAccount').text("パスワードが一致しません。");
			return;
		}
		else{
			$('.checkAccount').text("パスワードが一致しました。");
		}
	}
	
	function setState() {
	    var zip = $('.zip').val();

	    // ここでzipのバリデーションを行ってください
	    $.ajax({
	      type : 'get',
	      url : 'https://maps.googleapis.com/maps/api/geocode/json',
	      crossDomain : true,
	      dataType : 'json',
	      data : {
	        address : zip,
	        language : 'ja',
	        sensor : true
	      },
	      success : function(resp){
	        if(resp.status == "OK"){
	          // APIのレスポンスから住所情報を取得
	          var obj = resp.results[0].address_components;
	          if (obj.length < 5) {
	            alert('正しい郵便番号を入力してください');
	            return;
	          }
	          //$('#country').val(obj[4]['long_name']); // 国
	          $('.state').val(obj[3]['long_name']); // 都道府県
	          $('.city').val(obj[2]['long_name']);  // 市区町村
	          $('.address1').val(obj[1]['long_name']); // 番地
	        }else{
	         
	          $('.state').val('東京都');
	          $('.city').val('西東京市');
	          $('.address1').val('向台町');
	        }
	      }
	    });
	  }	

	function logout(){
		$.ajax({
			url : 'logout',
			method : 'get',
			success : function(res){
				count++;
				countA++;
				$('#home_btn').click();
			/*	$('#login__btn').show(500);
				$('#join__btn').show(500);
				$('#logout__btn').hide(500);
				$('#map__btn').hide(500);*/
			}
		})		
	}
	
	function mapWindow(){
		var showMap = "showMap";
		window.open(showMap, "map", "width=1400,height=625");
	}