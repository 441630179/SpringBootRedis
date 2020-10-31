$(function(){
    $.ajax({
        type: "post",
        url: "/SpringBoot/local/provList",
        success: function (data) {
            var returnCode = data.returnCode;
            var returnMsg = data.returnMsg;
            if (returnCode = "000000") {
                var provMap = data.provMap;
                for (var p in provMap){
                    $("#provId").append("<option value="+p+">"+provMap[p]+"</option>");
                }
            }
        },
        error: function (err) {
            if (data.status == '405') {

                window.location.reload();
            }
            $.growl.error({title: "失败", message: "网络异常，请稍后再试!" });
        }

    });



    $("#provId").change(function () {
        var param = $("#provId").val();
        $.ajax({
            type: "post",
            url: "/SpringBoot/local/cityList",
            data: {'localId':param},
            success: function (data) {
                var returnCode = data.returnCode;
                var returnMsg = data.returnMsg;
                if (returnCode = "000000") {
                    var cityMap = data.cityMap;
                    for (var p in cityMap){
                        $("#cityId").append("<option value="+p+">"+cityMap[p]+"</option>");
                    }
                }
            },
            error: function (err) {
                if (data.status == '405') {

                    window.location.reload();
                }
                $.growl.error({title: "失败", message: "网络异常，请稍后再试!" });
            }

        });
    });


    $("#cityId").change(function () {
        var param = $("#ctiyId").val();
        $.ajax({
            type: "post",
            url: "/SpringBoot/local/areaList",
            data: {'localId':param},
            success: function (data) {
                var returnCode = data.returnCode;
                var returnMsg = data.returnMsg;
                if (returnCode = "000000") {
                    var areaMap = data.cityMap;
                    for (var p in areaMap){
                        $("#areaId").append("<option value="+p+">"+areaMap[p]+"</option>");
                    }
                }
            },
            error: function (err) {
                if (data.status == '405') {

                    window.location.reload();
                }
                $.growl.error({title: "失败", message: "网络异常，请稍后再试!" });
            }

        });
    });


});

