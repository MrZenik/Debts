<html>
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Login</title>
</head>
<body>

<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form method="post" action="/login">
            <h2 class="d-flex justify-content-center">Увійти</h2>
            <div class="form-group">
                <#if userLogoutMessage??>
                    <div class="form-row form-control m-3 alert alert-danger" role="alert">${userLogoutMessage}</div>
                </#if>
                <#if incorrectDataMessage??>
                    <div class="form-row form-control m-3 alert alert-danger" role="alert">${incorrectDataMessage}</div>
                </#if>
                <input name="username" type="text" class="form-control m-3" placeholder="Ім`я користувача" autofocus="true" required>
                <input name="password" type="password" class="form-control m-3" placeholder="Пароль" required>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Увійти</button>
                </div>
            </div>
        </form>
        <form action="/user/register" method="get">
            <div class="form-row justify-content-center">
                 <input type="submit" class="btn btn-light m-3" value="Зареєструватися"/>
            </div>
        </form>
    </div>
</div>

</body>
</html>