<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>${message}</h2>

    <!-- Form that triggers the @PostMapping("/greet") -->
    <form action="greet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Submit</button>
    </form>
</body>
</html>