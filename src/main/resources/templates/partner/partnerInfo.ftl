<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Debts</title>
</head>
<body>
<#include "../include/navbar.ftl" >
    <h2 class="text-center p-3 d-flex justify-content-center">Інформація про партнера</h2>
    <div class="form-row justify-content-center d-flex">
        <ul class="list-group mr-1">
            <li class="list-group-item">Ім'я</li>
            <li class="list-group-item">Загальна сума боргу</li>
            <li class="list-group-item">Дата останньої зміни</li>
        </ul>
        <ul class="list-group">
            <li class="list-group-item">${partner.firstName + " " + partner.lastName}</li>
            <li class="list-group-item">${partner.debt}</li>
            <li class="list-group-item">
                ${(partner.updatedAt.monthValue?string?length<2) ?
                then("0" + partner.updatedAt.monthValue, partner.updatedAt.monthValue+"")

                + "." + (partner.updatedAt.dayOfMonth?string?length<2) ?
                then("0" + partner.updatedAt.dayOfMonth, partner.updatedAt.dayOfMonth+"")},

                ${partner.updatedAt.hour + ":" + (partner.updatedAt.minute?string?length<2) ?
                then('0'+partner.updatedAt.minute, partner.updatedAt.minute+'')}
            </li>
        </ul>
    </div>

    <div class="btn-group justify-content-center d-flex mt-2" role="group" aria-label="Basic example">
        <form action="/partners/delete/${partner.id}" method="post">
            <button class="btn btn-dark ml-1" type="submit">Видалити</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
        </form>

        <form action="/partners/edit/${partner.id}" method="get">
            <button class="btn btn-dark ml-1" type="submit">Редагувати</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
        </form>

        <form action="/debts/${partner.id}" method="get">
            <button class="btn btn-dark ml-1" type="submit">Історія транзакцій</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
        </form>
    </div>

</body>
</html>