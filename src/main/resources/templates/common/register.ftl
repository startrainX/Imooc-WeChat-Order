<html>
<#include "header.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/save">
                <div class="form-group">
                    <label>ID:</label>
                    <input name="sellerId" type="text" class="form-control"/>
                </div>
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

                <button type="submit" class="btn btn-default">注册</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>