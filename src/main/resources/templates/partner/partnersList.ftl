<!doctype html>
<html lang="en">
<html>
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Partners</title>
</head>
<body>
<#include "../include/navbar.ftl" >
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Ім'я</th>
            <th scope="col">Прізвище</th>
            <th scope="col">Сума боргу</th>
            <th scope="col">Дата зміни</th>
        </tr>
        </thead>
        <tbody>
        <#list partners as partner >
            <tr>
                <td>${partner.firstName}</td>
                <td>${partner.lastName}</td>
                <td>${partner.debt}</td>
                <td>${partner.updatedAt.month + " " + partner.updatedAt.dayOfMonth},
                    ${partner.updatedAt.hour + ":" + partner.updatedAt.minute}
                </td>
                <td>
                    <form action="/partners/delete/${partner.id}" method="post">
                        <button class="btn btn-light" type="submit">Видалити</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
                    </form>
                </td>
                <td>
                    <form action="/partners/edit/${partner.id}" method="get">
                        <button class="btn btn-light" type="submit">Редагувати</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <form action="/partners/new" method="get">
        <div class="form-row justify-content-center">
            <input type="submit" class="btn btn-light m-3" value="Додати партнера"/>
        </div>
    </form>

</body>
</html>