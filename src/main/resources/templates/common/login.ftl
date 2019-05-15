<html>
<#include "header.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="get" action="/sell/seller/login">
                <div class="form-group">
                    <label>UserName:</label>
                    <input name="username" type="text" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input name="password" type="password" class="form-control" />
                </div>
                <div class="form-group">
                    <label>OpenId:</label>
                    <input name="openid" type="text" class="form-control"/>
                </div>

                <div class="checkbox">
                    <label><input type="checkbox" />Check me out</label>
                </div>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>