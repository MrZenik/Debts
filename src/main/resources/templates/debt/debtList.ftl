<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Debts</title>
</head>
<body>
<#include "../include/navbar.ftl" >
    <table class="table table-striped" >
        <thead>
            <tr>
                <th scope="col">Сума транзакції</th>
                <th scope="col">Дата транзакції</th>
                <th scope="col">Коментар</th>
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
                    <form action="/debts/delete/${debt.id}" method="post" class="ml-2">
                        <button class="btn btn-dark" type="submit">Видалити</button>
                        <input type="hidden" name="partnerId" value="${partner.id}"/><br>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div class="justify-content-center d-flex">
        <form action="/debts/create/${partner.id}" method="get">
            <button class="btn btn-dark" type="submit">Додати транзакцію</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
        </form>
        <form action="/partners/${partner.id}" method="get" class="ml-2">
            <button class="btn btn-dark" type="submit">Повернутися назад</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
        </form>
    </div>
</body>
</html>