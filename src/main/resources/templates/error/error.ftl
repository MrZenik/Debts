<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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