<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- /container -->
<div id="container-4" class="container theme-1">
	<header class="intro">
		<img class="intro__image" src="img/4.jpg" alt="Glacier" />
		<div class="intro__content">

			<div id="controls" align="right" style="margin-bottom: 5px;">
				住所 : <select id="country">
					<option value="">選択</option>
					<option value="Shinjuku">全て</option>
					<option value="Akita">秋田県</option>
					<!-- 홋카이도현(삿포로)  -->
					<option value="Hiroshima">広島県</option>
					<!-- 아오모리  시  -->
					<option value="Morioka">岩手県</option>
					<!-- 이와테 현(모리오카시)  -->
					<option value="Sendai">宮城県</option>
					<!-- 미야기현 (센다이 시)  -->
					<option value="Sapporo">北海道</option>
					<!-- 아키타 시-->
					<option value="Yamagata">山形県</option>
					<!-- 야마가타 시 -->
					<option value="kunimi">福島県</option>
					<!-- 후쿠시마 시-->
					<option value="ibaraki">茨城県</option>
					<!-- 아바라키현(미토 시)  -->
					<option value="Tochigi">栃木県</option>
					<!-- 도치기현(우쓰노미야 시)   -->
					<option value="Takasaki">群馬県</option>
					<!-- 군마현(마에바시 시) -->
					<option value="saitama">埼玉県</option>
					<!-- 사이타마 현(오오미야)  -->
					<option value="chiba">千葉県</option>
					<!-- 지바 시  -->
					<option value="Kyoto">京都府</option>
					<!-- 교토 시  -->
					<option value="Yokohama">神奈川県</option>
					<!-- 가나가와현(요코하마 시) -->
					<option value="Niigata">新潟県</option>
					<!-- 니가타 시 -->
					<option value="Toyama">富山県</option>
					<!-- 도야마 시  -->
					<option value=Kanazawa>石川県</option>
					<!-- 이시카와 현(가나자와 시) -->
					<option value="Fukui">福井県</option>
					<!-- 후쿠이 시  -->
					<option value="Yamanashishi">山梨県</option>
					<!-- 야마나현(야마나시 시) -->
					<option value="Nagano">長野県</option>
					<!-- 나가노 시 -->
					<option value="Gifu">岐阜県</option>
					<!-- 기후 시  -->
					<option value="Shizuoka">静岡県</option>
					<!-- 시즈오카 시  -->
					<option value="Nagoya">愛知県</option>
					<!-- 아이치 현(나고야 시)  -->
					<option value="Mie Prefecture">三重県</option>
					<!-- 미에현  -->
					<option value="Maibara">滋賀県</option>
					<!-- 시가(마이바라)     -->
					<option value="Kyoto">京都府</option>
					<!-- 교토 시  -->
					<option value="Osaka">大阪府</option>
					<!-- 오사카 시  -->
					<option value="Hyogo">兵庫県</option>
					<!-- 효고현 (효고시)  -->
					<option value="Nara">奈良県</option>
					<!-- 나라 시  -->
					<option value="Wakayama">和歌山県</option>
					<!-- 와카야마 시  -->
					<option value="Tottori">鳥取県</option>
					<!-- 돗토리 시 -->
					<option value="Izumoshi">島根県</option>
					<!-- 시마네현(이즈모 시)  -->
					<option value="Okayama">岡山県</option>
					<!-- 오카야마 시  -->
					<option value="Aomori">青森県</option>
					<!-- 히로시마 시  -->
					<option value="Yamaguchi">山口県</option>
					<!-- 야마구치 시  -->
					<option value="Tokushima">徳島県</option>
					<!-- 도쿠시마 시  -->
					<option value="Takamatsu">香川県</option>
					<!-- 가가와 현 (다카마츠 시)-->
					<option value="Matsuyama">愛媛県</option>
					<!-- 에히메현(마쓰야마 시)  -->
					<option value="Nankoku">高知県</option>
					<!-- 고치 시  -->
					<option value="HAKATA">福岡県</option>
					<!-- 후쿠오카 현(하카타시)  -->
					<option value="tosu">佐賀県</option>
					<!-- 사가 시  -->
					<option value="NAGASAKI">長崎県</option>
					<!-- 나가사키 시  -->
					<option value="KUMAMOTO">熊本県</option>
					<!-- 오쓰구마모토시  -->
					<option value="OITA">大分県</option>
					<!-- 오이타 시  -->
					<option value="MIYAZAKI">宮崎県</option>
					<!-- 미야자키 시  -->
					<option value="KAGOSHIMA">鹿児島県</option>
					<!-- 가고시마 시 --> 
					<option value="Naha Airport">沖縄県
					</option>
					<!-- 오키나와현(나하공항)  -->
				</select>
			</div>
			<div id="productMap"></div>


			<h1 class="intro__title">SpecialProductBoard</h1>
			<div class="intro__subtitle">
				<div class="intro__description">
					<div class="demos">
						<span></span>
						<button class="btn_change home__btn button button--sacnite button--round-l">ホーム</button>
						<button id="special__btn" class="trigger btn_change button button--sacnite button--round-l">特産物</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /intro__content -->
	</header>
	<section class="related1">
		<div id="searchdiv"></div>

			<!-- code here -->

			<div id="board__list">
				<div id="productionImage"></div>
				<div id="production"></div>
			</div>
			<div class="opcity">d</div>
	</section>

</div>
