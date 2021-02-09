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
    </div>

<table class="table table-striped mt-5" >
    <thead>
        <tr>
            <th scope="col">Сума транзакції</th>
            <th scope="col">Дата транзакції</th>
            <th scope="col">Коментар</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
    <#list debts as debt >
        <tr >
            <td>${debt.transactionAmount}</td>
            <td>
                ${(debt.transactionDate.monthValue?string?length<2) ?
                then("0" + debt.transactionDate.monthValue, debt.transactionDate.monthValue+"")

                + "." + (debt.transactionDate.dayOfMonth?string?length<2) ?
                then("0" + debt.transactionDate.dayOfMonth, debt.transactionDate.dayOfMonth+"")},

                ${debt.transactionDate.hour + ":" + (debt.transactionDate.minute?string?length<2) ?
                then('0'+debt.transactionDate.minute, debt.transactionDate.minute+'')}
            </td>
            <td>${debt.comment}</td>
            <td>
                <form action="/partners/${partnerId}/debts/delete/${debt.id}" method="post" class="ml-2">
                    <button class="btn btn-dark" type="submit">Видалити</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
                </form>
            </td>
            <td>
                <form action="/partners/${partnerId}/debts/edit/${debt.id}" method="get" class="ml-2">
                    <button class="btn btn-dark" type="submit">Редагувати</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

<div class="justify-content-center d-flex">
    <form action="/partners/${partnerId}/debts/create" method="get">
        <button class="btn btn-dark" type="submit">Додати транзакцію</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
    </form>
</div>
</body>
</html>