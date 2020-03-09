<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<%!
    // --- String Join Function converts from Java array to javascript string.
    public String join(ArrayList<?> arr, String del)
    {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < arr.size(); i++)
        {

            if (i > 0) output.append(del);

            // --- Quote strings, only, for JS syntax
            if (arr.get(i) instanceof String) output.append("\"");
            output.append(arr.get(i));
            if (arr.get(i) instanceof String) output.append("\"");
        }

        return output.toString();
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <style>
        a{
            color: white;
        }
        a:hover{
            color: lightcyan;
        }
    </style>
</head>
<body class="sb-nav-fixed">
<script>
    <%
       // --- Create two Java Arrays
        ArrayList<String> months = new ArrayList<String>();
        ArrayList<Integer> users = new ArrayList<Integer>();
        String[] monthName = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
        for(int i = 0; i<monthName.length;i++){
            months.add(monthName[i]);
            users.add(i);
        }
    %>

    // --- add a comma after each value in the array and convert to javascript string representing an array
    var monthData1 = [<%= join(months, ",") %>];
    var userData1 = [<%= join(users, ",") %>];
    var monthData2 = [<%= join(months, ",") %>];
    var userData2 = [<%= join(users, ",") %>];

</script>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html">Library Online</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button
><!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>

    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">Signup</a><a class="dropdown-item" href="#">Login</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="login.html">Logout</a>
            </div>
        </li>
    </ul>
</nav>
<aside style="width: 270px; height: 1500px; border:1px solid black; float: left; margin: 0; background: #323e52; color: white">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div style="text-align: center; font-size: 25px">Manage</div>
            <a class="nav-link" href="index.html"
            ><div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                Profile</a
            >
            <div class="nav">
                <a class="nav-link collapsed" style="display: block" href="#" data-toggle="collapse" data-target="#manageBooks" aria-expanded="false" aria-controls="collapseLayouts"
                ><div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Manage Books
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                    ></a>
                <div class="collapse" id="manageBooks" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}?action=addPage">Add</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}?action=editPage">Edit</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}?action=deletePage">Delete</a>
                    </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                ><div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Manage Readers
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                    ></a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="layout-static.html">Add</a>
                        <a class="nav-link" href="layout-sidenav-light.html">Edit</a>
                        <a class="nav-link" href="layout-sidenav-light.html">Delete</a></nav>
                </div>
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages"
                ><div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    View All Books
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                    ></a>
                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth"
                        >Authentication
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="login.html">Login</a><a class="nav-link" href="register.html">Register</a><a class="nav-link" href="password.html">Forgot Password</a></nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError"
                        >Error
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                        <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="401.html">401 Page</a><a class="nav-link" href="404.html">404 Page</a><a class="nav-link" href="500.html">500 Page</a></nav>
                        </div>
                    </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#viewAllReaders" aria-expanded="false" aria-controls="collapsePages"
                ><div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    View All Readers
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                    ></a>
                <div class="collapse" id="viewAllReaders" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavViewAllReaders">
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth"
                        >Authentication
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                    </nav>
                </div>
            </div>
            <a class="nav-link" href="charts.html"
            ><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                Charts</a
            ><a class="nav-link" href="tables.html"
        ><div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
            Tables</a
        >
        </div>

        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            Start Bootstrap
        </div>
    </nav>
</aside>

<section style="float: right; width: 1550px;height: 1500px; margin: 0; padding: 0" >
    <div class="container-fluid">
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Dashboard</li>
        </ol>
        <div class="row">
            <div class="col-xl-3 col-md-6">
                <div class="card bg-primary text-white mb-4">
                    <div class="card-body">Issued Books</div>
                    <div class="card-footer d-flex align-items-center">
                        <a class="text-white" style="font-size: 16px">Quantity:</a>
                        <div class="text-white" style="font-size: 16px; margin-left: 10px"><c:out value="${issuedBookQuantity}"></c:out></div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6">
                <div class="card bg-warning text-white mb-4">
                    <div class="card-body">Readers Quantity</div>
                    <div class="card-footer d-flex align-items-center">
                        <a class="small text-white stretched-link" href="#" style="font-size: 16px">Quantity:</a>
                        <div class="text-white" style="font-size: 16px; margin-left: 10px"><c:out value="${readerQuantity}"></c:out> </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6">
                <div class="card bg-success text-white mb-4">
                    <div class="card-body">Loanded Books</div>
                    <div class="card-footer d-flex align-items-center">
                        <a class="small text-white stretched-link" href="#" style="font-size: 16px">Quantity:</a>
                        <div class="text-white" style="font-size: 16px; margin-left: 10px"><c:out value="${loanedBookQuantity}"></c:out> </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6">
                <div class="card bg-danger text-white mb-4">
                    <div class="card-body">Available Books</div>
                    <div class="card-footer d-flex align-items-center" >
                        <a class="small text-white stretched-link" href="#" style="font-size: 16px">Quantity:</a>
                        <div class="text-white" style="font-size: 16px; margin-left: 10px"><c:out value="${availableBookQuantity}"></c:out> </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-chart-area mr-1"></i>Book Chart</div>
                    <div class="card-body" >
                        <canvas id="myAreaChart" width="100%" height="40"></canvas>
                        <div id="myBookChart"></div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-chart-bar mr-1"></i>Reader Chart</div>
                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                    <div id="myReaderChart"></div>
                </div>
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-table mr-1" ></i>Books Information</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>BookId</th>
                            <th>Book Name</th>
                            <th>Type Of Book</th>
                            <th>Author Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Language</th>
                            <th>Status</th>
                            <th>Situation</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>BookId</th>
                            <th>Book Name</th>
                            <th>Type Of Book</th>
                            <th>Author Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Language</th>
                            <th>Status</th>
                            <th>Situation</th>
                        </tr>
                        </tfoot>
                        <tbody>

                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td><c:out value="${book.getBookId()}"></c:out></td>
                                <td><c:out value="${book.getBookName()}"></c:out></td>
                                <td><c:out value="${book.getTypeOfBook()}"></c:out></td>
                                <td><c:out value="${book.getAuthor()}"></c:out></td>
                                <td><c:out value="${book.getQuantity()}"></c:out></td>
                                <td><c:out value="${book.getPrice()}"></c:out></td>
                                <td><c:out value="${book.getLanguage()}"></c:out></td>
                                <td><c:out value="${book.getStatus()}"></c:out></td>
                                <td><c:out value="${book.getSituation()}"></c:out></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="py-4 bg-light mt-auto" style="clear: both">
    <div class="container-fluid">
        <div class="d-flex align-items-center justify-content-between small">
            <div class="text-muted">Copyright &copy; Your Website 2019</div>
            <div>
                <a href="#">Privacy Policy</a>
                &middot;
                <a href="#">Terms &amp; Conditions</a>
            </div>
        </div>
    </div>
</footer>
<script>
    window.onload = function() {
        zingchart.render({
            id: "myBookChart",
            width: "100%",
            height: 400,
            background: "cyan",
            data: {
                "type": "bar",
                "title": {
                    "text": "Loaned Book by Month"
                },
                "scale-x": {
                    "labels": monthData1
                },
                "plot": {
                    "line-width": 1
                },
                "series": [{
                    "values": userData1
                }]
            }
        });
        zingchart.render({
            id: "myReaderChart",
            width: "100%",
            height: 400,
            data: {
                "type": "bar",
                "title": {
                    "text": "Reader By Month"
                },
                "scale-x": {
                    "labels": monthData2
                },
                "plot": {
                    "line-width": 1
                },
                "series": [{
                    "values": userData2
                }]
            }
        });
    };

</script>


</body>

</html>
