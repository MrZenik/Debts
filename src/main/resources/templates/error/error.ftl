<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <link rel="stylesheet" href="/css/error.css">
    <title>Error</title>
</head>
<body>
<div class = "error">
    <img src="/img/error-photo.png" alt="error">
    <#if errorCode??>
        <h1>Error ${errorCode}</h1>
    </#if>
    <#if errorMessage??>
        <h2>Error message: ${errorMessage}</h2>
    </#if>
</div>

</body>
</html>