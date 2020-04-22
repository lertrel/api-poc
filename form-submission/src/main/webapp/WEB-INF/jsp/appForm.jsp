<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>form submit exercise</title>
</head>

<body>
    <h2>Application Details</h2>
    <form method="post" action="viewAppDetails"> Enter Name : <input type="text" name="name" /> <br> Enter Email
        Address: <input type="email" name="email"> <br> <input type="submit" value="Submit"> </form>


    <br /> 
    <table>
        <caption>List of cusotmers</caption>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>
                    <c:out value="${customer.id}" />
                </td>
                <td>
                    <c:out value="${customer.name}" />
                </td>
                <td>
                    <c:out value="${customer.email}" />
                </td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>