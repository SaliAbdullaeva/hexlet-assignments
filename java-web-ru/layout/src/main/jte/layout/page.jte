@import gg.jte.Content

@param Content header
@param Content content
@param Content footer = null

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header class="d-flex justify-content-center py-3">
    ${header}
</header>
<div class="content">
    ${content}
</div>
@if (footer != null)
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        ${footer}
    </footer>
@endif
</body>
