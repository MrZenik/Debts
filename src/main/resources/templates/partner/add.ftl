<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Document</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<form action="/partners/new" method="post" class="form-signin">
    <div class="w-100 h-100 d-flex align-items-center justify-content-center">
        <div class="col-md-8">
            <h2 class="form-heading text-center p-3">Додати партнера</h2>
            <div class="form-group">
                <input name="firstName" type="text" class="form-control m-3" placeholder="Ім'я" autofocus="true" required/>
                <input name="lastName" type="text" class="form-control m-3" placeholder="Прізвище" autofocus="true" required/>
                <input name="debt" type="number" step="any" class="form-control m-3" placeholder="Сума боргу"
                       autofocus="true" required/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Додати</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>