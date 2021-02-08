<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Partners</title>
</head>
<body>
    <#include "../include/navbar.ftl" >
    <form action="/partners/new" method="get">
        <div class="form-row justify-content-center">
            <input type="submit" class="btn btn-dark m-3" value="Додати партнера"/>
        </div>
    </form>

    <table class="table table-bordered">
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
            <tr class="list-group-item-action" onclick="window.location='/partners/${partner.id}';">
                <td>${partner.firstName}</td>
                <td>${partner.lastName}</td>
                <td>${partner.debt}</td>
                <td>
                    ${(partner.updatedAt.monthValue?string?length<2) ?
                        then("0" + partner.updatedAt.monthValue, partner.updatedAt.monthValue+"")

                    + "." + (partner.updatedAt.dayOfMonth?string?length<2) ?
                        then("0" + partner.updatedAt.dayOfMonth, partner.updatedAt.dayOfMonth+"")},

                    ${partner.updatedAt.hour + ":" + (partner.updatedAt.minute?string?length<2) ?
                        then('0'+partner.updatedAt.minute, partner.updatedAt.minute+'')}
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</body>
</html>