<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Registration</title>
</head>
<body>
<#include "../include/navbar.ftl" >
    <div class="w-100 h-100 d-flex align-items-center justify-content-center">
        <div class="col-md-8">
            <form action="/user/register" method="POST" class="form-signin">
                <h2 class="form-heading text-center p-3">Реєстрація</h2>
                <div class="form-group">
                    <input name="firstName" type="text" class="form-control m-3" placeholder="Ім'я"
                           autofocus="true" required/>
                    <input name="lastName" type="text" class="form-control m-3" placeholder="Прізвище"
                           autofocus="true" required/>
                    <input name="username" type="email" class="form-control m-3" placeholder="Email"
                           autofocus="true" required/>
                    <input name="password" type="password" class="form-control m-3" placeholder="Пароль" required/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="form-row justify-content-center">
                        <button class="btn btn-primary p-3 w-50" type="submit">Зареєстуватися</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <form action="/login" method="get">
        <div class="form-row justify-content-center">
            <input type="submit" class="btn btn-light m-3" value="Увійти"/>
        </div>
    </form>
</body>
</html>