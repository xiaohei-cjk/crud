<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/static/js/jquery-3.3.1.js"></script>
<body>
</body>

请选择省份：
<select id="province"></select>
<br>
请选择市：
<select id="city"></select>

<script>
    $(function () {
        $.ajax({
            url: "/province",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';

                for (var i = 0; i < data.length; i++) {
                    html = html + "<option value='" + data[i].id + "'>" + data[i].name + "</option>"
                }

                $("#province").append(html);
            },
            error: function () {

            }
        });



        $("#province").change(function () {
            var id = $("#province option:selected").val();
            if(id==-1){
                $("#city").empty();
                return;
            }

            $.ajax({
                url: "/city",
                type: "get",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    $("#city").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#city").append(html);
                }
            });
        });
    });
</script>
</html>
