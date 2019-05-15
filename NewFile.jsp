<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RunJS</title>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/289/za0sqcyf/jquery-1.6.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $("button").click(function(){
                    var html = "<tr><td style='border:1px solid black;'>add aline</td><td style='border:1px solid black;'>add a line</td></tr>";   //自己定义好要添加的信息
                    $("table").append(html);  //添加对应的内容到table
                });
            });
        </script>
    </head>
    <body>
        <button>Hello </button>
        <table style="border:1px solid yellow;">
            
        </table>
    </body>
</html>