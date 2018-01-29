/**
 * Created by DELL on 2017/4/17.
 */
(function ($) {
    var DEFAULT_OPTION = {
        avatar: "../image/avatar@24.png",//头像
        msg: "Hello World",//信息
        close: false//是否显示关闭按钮
        // time:8
    }
    var WIN_HEIGHT = $(window).height()
    var WIN_WIDTH = $(window).width()


    var barrage = {
        init: function (options) {
            options = $.extend({}, DEFAULT_OPTION, options || {})
            var barrageWapper = $('<div class="barrage-wrapper"></div>')
            var barrageContent = $('<span class="barrage-content"></span>')
            barrageContent.append('<a href="javascript:;">' + options.msg + '</a>')
            var ftColor = "rgb(" + Math.floor(Math.random() * 255) + "," + Math.floor(Math.random() * 255) + "," + Math.floor(Math.random() * 255) + ")"
            barrageContent.css("color", ftColor)
            if (options.close) {
                barrageContent.append('<span class="barrage-close"></span>')
            }
            barrageWapper.append(barrageContent)
            $(this).css("position", "relative").append(barrageWapper)

            //calc start position
            var elm_height = $(this).height()
            var loc = Math.random() * (elm_height - 20)

            barrageWapper.css({
                "top": loc + "px"
            })
            if (options.time) {
                barrageWapper.css({
                    "animation-duration": options.time + "s"
                })
            } else {
                barrageWapper.css({
                    "animation-duration": 5 + Math.floor(Math.random() * 5) + "s"
                })
            }

            setInterval(function () {
                $(".barrage-wrapper").on('webkitAnimationEnd', function () {
                    $(this).remove()
                })
            }, 1000)
        }
    }
    $.fn.barrage = function(method){
        if ( barrage[method] ) {
            return barrage[method].apply( this, Array.prototype.slice.call( arguments, 1 ));
        } else if ( typeof method === 'object' || ! method ) {
            return barrage.init.apply( this, arguments );
        } else {
            $.error( '不存在 ' +  method + ' 方法' );
        }
    }
})(jQuery)
