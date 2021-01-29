<#include "security.ftl" >
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <p class = "navbar-brand">MyDebts</p>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/partners">Мої партнери <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <span class="navbar-text">
            <form action="/logout" method="POST">
                ${name}
                <button class="btn btn-light" type="submit">logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
            </form>
        </span>
    </div>
</nav>