<div class="header-wrap parent">
    <div id="top">
        <nav class="col-full" role="navigation">
            <ul id="top-nav" class="nav fl">
                <li id="menu-item-165" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-165">
                    <sec:authorize access="isAuthenticated()">
                        <span id="name">Welcome ${current_person.firstname} ${current_person.surname} (${user.username})</span>
                        <a href="<%= request.getContextPath()%>/<c:url value="j_spring_security_logout" />" >Logout</a>
                        <a href="<%= request.getContextPath()%>/admin/user/viewmyprofile">My Profile</a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a href="<%= request.getContextPath()%>/admin">Login</a>
                    </sec:authorize>
                </li>
            </ul>
        </nav>
    </div><!-- /#top -->

    <header id="header" class="parent">
        <div class="nav-wrap parent">
            <nav id="navigation" class="col-full parent" role="navigation">
                <h1 class="site-title"><a href="<%= request.getContextPath()%>">IRS</a></h1>
                <h3 class="nav-toggle"><a href="#navigation">Navigation</a></h3>

                <ul id="main-nav" class="nav parent">
                    <sec:authorize access="isAnonymous()">
                        <li class="menu-item">
                            <a href="<%= request.getContextPath()%>/">Home</a>
                        </li>
                        <li class="menu-item">
                            <a href="<%= request.getContextPath()%>/about">About Us</a>
                        </li>
                        <li class="menu-item">
                            <a href="<%= request.getContextPath()%>/contact">Contact Us</a>
                        </li>
                    </sec:authorize>
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li id="menu-item-82" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-82 parent">
                        <a href="#">Analysis</a>
                        <ul class="sub-menu">
                            <li id="menu-item-170" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-170">
                                <a href="<%= request.getContextPath()%>/performance">Performance</a>
                            </li>
                            <li id="menu-item-79" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-79">
                                <a href="<%= request.getContextPath()%>/risk">Risk</a>
                            </li>
                            <li id="menu-item-112" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-112">
                                <a href="<%= request.getContextPath()%>/attributions">Attributions</a>
                            </li>
                            <li id="menu-item-81" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-81">
                                <a href="<%= request.getContextPath()%>/assets">Assets</a>
                            </li>
                            <li id="menu-item-2457" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2457">
                                <a href="<%= request.getContextPath()%>/compliance">Compliance</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li id="menu-item-82" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-82 parent">
                        <a href="#">Admin</a>
                        <ul class="sub-menu">
                            <li id="menu-item-87" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-87">
                                <a href="<%= request.getContextPath()%>/admin/user">User</a>
                            </li>
                            <li id="menu-item-84" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84">
                                <a href="<%= request.getContextPath()%>/admin/assetmanager">Asset Manager</a>
                            </li>
                            <li id="menu-item-85" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-85">
                                <a href="<%= request.getContextPath()%>/admin/investor">Investor</a>
                            </li>
                            <li id="menu-item-87" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-87">
                                <a href="<%= request.getContextPath()%>/admin/trusteerole">Trustee Role</a>
                            </li>
                            <li id="menu-item-87" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-87">
                                <a href="<%= request.getContextPath()%>/admin/role">User Roles</a>
                            </li>
                        </ul>
                    </li>
                    </sec:authorize>
                </ul>
            </nav><!-- /#navigation -->

        </div><!-- /.nav-wrap-->

    </header><!-- /#header -->

</div>
<div id="wrapper">
    <div id="content" class="page col-full layout-full">