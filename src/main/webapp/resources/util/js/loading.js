function Loading () {
	
	this.blockPage = function () {
		var cmp = PF('blockBodyUIWidget');
		if (cmp) cmp.show();
	};
	
	this.unblockPage = function (cb) {
		var cmp = PF('blockBodyUIWidget');
		if (cmp) cmp.hide();
		if (cb) cb();
	};
};

var loading = new Loading();