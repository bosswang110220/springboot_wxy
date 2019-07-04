(function($) {

	var Index = function() {
		var url = {

			dishUrl: 'subItem/dish/index.html',
			orderUrl: 'subItem/order/index.html',
			homeUrl: 'subItem/home.html',
			shopUrl: 'subItem/shop/index.html',
			foodUrl: 'subItem/food/index.html'
		};

		return {

			init: function() {
				$(".main-content").getAjaxHTML(url.homeUrl, function(html, obj) {
					obj.html(html);
				});
			},

			/**
			 * 菜品分类点击事件
			 */
			dish: function() {
				$('.sidebar').on('click', '[opr="dish"] a', function() {
					$(".main-content").getAjaxHTML(url.dishUrl, function(html, obj) {
						obj.html(html);
					});
				});
			},

			/**
			 * 订单点击事件
			 */
			order: function() {
				$('.sidebar').on('click', '[opr="order"] a', function() {
					$(".main-content").getAjaxHTML(url.orderUrl, function(html, obj) {
						obj.html(html);
					});
				});
			},

			/**
			 * 加载菜品
			 */
			food: function() {
				$('.sidebar').on('click', '[opr="food"]', function() {
					$(".main-content").getAjaxHTML(url.foodUrl, function(html, obj) {
						obj.html(html);
					});
				});
			},
			/**
			 * 加载首页
			 */
			home: function() {
				$('.sidebar').on('click', '[opr="home"]', function() {
					Index.init();
				});
			},
			/**
			 * 商家基本信息
			 */
			shop: function() {
				$('.sidebar').on('click', '[opr="shop"]', function() {
					$(".main-content").getAjaxHTML(url.shopUrl, function(html, obj) {
						obj.html(html);
					});
				});
			},
			logout: function() {
				$('.header ul li').on('click', '[opr="logout"]', function() {
					window.location.href = "login.html";
				});
			},
			

		};

	}();
	$(document).ready(function() {
		Index.init();
		Index.home();
		Index.dish();
		Index.order();
		Index.food();
		Index.shop();
		Index.logout();

	});
})(jQuery);