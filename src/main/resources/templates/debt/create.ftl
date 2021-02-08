<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Debts</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/debts/create/${partnerId}" method="post" class="form-signin">
            <h2 class="form-heading text-center p-3">Додати транзакцію</h2>
            <div class="form-group">
                <input name="transactionAmount" type="number" step="any" class="form-control m-3" placeholder="Сума"
                       autofocus="true" required/>
                <input name="comment" type="text" class="form-control m-3" placeholder="Коментар" required/>
                <input name="transactionDate" id="datetime-local" type="datetime-local" class="form-control m-3" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Додати</button>
                </div>
            </div>
        </form>
    </div>
</div>
    <script>
        let today = new Date();
        let dd = today.getDate();
        let mm = today.getMonth() + 1;
        let yyyy = today.getFullYear();
        let minutes = today.getMinutes();
        let hour = today.getHours();
        if(dd < 10){
            dd='0' + dd
        }
        if(mm < 10){
            mm='0' + mm
        }
        if(hour < 10){
            hour='0' + hour
        }
        if(minutes < 10){
            minutes='0' + minutes
        }

        today = yyyy + '-' + mm + '-' + dd + 'T' + hour + ':' + minutes;
        document.getElementById("datetime-local").setAttribute("max", today);
    </script>
</body>
</html>