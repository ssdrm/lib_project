/*function initTopMenu(el,depth1) {
	topMenuOut(el.getElementsByTagName("img").item(0));
	if(el.id == "top-menu" + depth1) {
		topMenuOver(el.getElementsByTagName("img").item(0));
	}
}
function topMenuOver(img) {
	img.src = img.src.replace(".gif", "_over.gif");
}
function topMenuOut(img) {
	img.src = img.src.replace("_over.gif", ".gif");
}*/
function selectTopmenuByMenuId() {
	var depth1 = this.id.substring("top-menu-head".length,this.id.length);
	var menuId = "sub-menu" + depth1;
	var selectDepth1 = "top-" + depth1 + "-1";
	var topnav = document.getElementById("mainMenu");
	if(!topnav) return;
	var topEl = topnav.getElementsByTagName("ul");
	for(i = 0 ; i < topEl.length ; i++){
		if(topEl[i].id.substring(0,12) == "top-sub-menu") {
			topEl[i].style.display = "none";
		}
	}
	var topEl2 = topnav.getElementsByTagName("li");
	for(i = 0 , seq = 1; i < topEl2.length ; i++){
		if(topEl2[i].id.substring(0,8) == "top-menu") {
			/*initTopMenu(topEl2[i],depth1);*/
			/* 스크립트 추가 시작 */
			topEl2[i].onmouseover = function(){
				this.style.display = 'block';
				this.firstChild.className = 'on';
				this.onmouseout = function(){
					this.firstChild.className = '';
					this.getElementsByTagName('ul')[0].style.display = 'none';
					/*this.getElementsByTagName('ul')[0].style.display = 'block';*/
				}
			}
			/* 스크립트 추가 끝 */

		}
		if(topEl2[i].id.substring(0,8) == "position") {
			if(depth1 == seq) topEl2[i].style.display = "block";
			else topEl2[i].style.display = "none";
			seq++;
		}
	}
	
	var nav = document.getElementById("top-" + menuId);
	if(!nav) return;
	nav.style.display = "block";
	/* 스크립트 추가 시작 */
	nav.onmouseover = function(){
		this.style.display = 'block';
		this.onmouseout = function(){
			this.style.display = 'none';
		}
	}
	/* 스크립트 추가 끝 */
	menuEl = nav.getElementsByTagName("li");
	for(i = 0; i < menuEl.length; i++) {
		var imgEl = menuEl.item(i).getElementsByTagName("img")
		if(imgEl != null && imgEl.length>0) {
			imgEl.item(0).onmouseover = menuOver;
			imgEl.item(0).onmouseout = menuOut;
			imgEl.item(0).onfocus = menuOver;
			imgEl.item(0).onblur = menuOut;
		}
	}
}


function initTopmenuByMenuId(depth1, depth2, depth3, depth4, menuId) {
	var selectDepth1 = "top-" + depth1 + "-" + depth2;
	var selectDepth2 = "top-" + depth1 + "-" + depth2 + "-" + depth3;
	var selectDepth3 = "top-" + depth1 + "-" + depth2 + "-" + depth3 + "-" + depth4;
	var topnav = document.getElementById("mainMenu");
	if(!topnav) return;
	var topEl = topnav.getElementsByTagName("ul");	
	for(var i = 0 ; i < topEl.length ; i++){
		if(topEl[i].id.substring(0,12) == "top-sub-menu") {
			topEl[i].style.display = "none";
		}
	}
	var topEl3 = topnav.getElementsByTagName("li");
	for(i = 0 , seq = 1; i < topEl3.length ; i++){
		if(topEl3[i].id.substring(0,8) == "position") {
			if(depth1 == seq) topEl3[i].style.display = "block";
			else topEl3[i].style.display = "none";
			seq++;
		}
	}
	
	var topEl2 = topnav.getElementsByTagName("a");
	for(i = 0 , seq = 0; i < topEl2.length ; i++){
		if(topEl2[i].id.substring(0,13) == "top-menu-head") {
			topEl2[i].onmouseover =  selectTopmenuByMenuId;
			topEl2[i].onfocus = selectTopmenuByMenuId;
			if ( seq+1 == depth1) {
				topEl2[i].onmouseover();
				topEl2[i].onfocus();
			}
			seq++;
		}
	}
	
	var nav = document.getElementById("top-sub-" + menuId);
	if(!nav) return;
	nav.style.display = "block";
	menuEl = nav.getElementsByTagName("li");
	for(i = 0; i < menuEl.length; i++) {
		var menuElItm = menuEl.item(i);
		var imgEl = menuElItm.getElementsByTagName("img");
		if(imgEl == null || imgEl.length == 0) continue;
		var itm = imgEl.item(0);
		if (menuElItm.id == selectDepth1 || menuElItm.id == selectDepth2  || menuElItm.id == selectDepth3  ) {
			itm.src = itm.src.replace(".gif", "_over.gif");
			itm.onmouseover = null;
			itm.onmouseout = null;
			itm.onfocus = null;
			itm.onblur = null;
		}
		else {
			itm.onmouseover = menuOver;
			itm.onmouseout = menuOut;
			itm.onfocus = menuOver;
			itm.onblur = menuOut;
		}
	}
}
