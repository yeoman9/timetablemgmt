<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en"> <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <title>Timetablemgmt - Login Form</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style-metro.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
        <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="assets/css/pages/login-soft.css" rel="stylesheet" type="text/css"/>
        <!-- END PAGE LEVEL STYLES -->
        <link rel="shortcut icon" href="assets/favicon.ico" />
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    </head>
    <!-- END HEAD -->
    <!-- BEGIN BODY -->
    <body class="login">
        <!-- BEGIN LOGO -->
        <div class="logo">
            <img src="assets/img/logo-big.png" alt="" /> 
        </div>
        <!-- END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN LOGIN FORM -->
            <form:form id="form-login" class="form-vertical login-form"  commandName="loginAuth" action="LoginAuth.htm" method="post">
                <h3 class="form-title">Login to your account</h3>
                <!--			<div class="alert alert-error hide">
                                                <button class="close" data-dismiss="alert"></button>
                                                <span>Enter any username and password.</span>
                                        </div>-->
                <div class="control-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Username</label>
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-user"></i>
                            <form:input path="username" class="m-wrap placeholder-no-fix" type="text" placeholder="Username"></form:input>
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label visible-ie8 visible-ie9">Password</label>
                        <div class="controls">
                            <div class="input-icon left">
                                <i class="icon-lock"></i>
                            <form:input path="password" class="m-wrap placeholder-no-fix" type="password" placeholder="Password" ></form:input>
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/> Remember me
                        </label>
                        <!--                            <button type="button" name="login" onclick="loginCheck();" class="btn blue pull-right"></button>
                                                Login <i class="m-icon-swapright m-icon-white"></i>-->
                        <button type="button" class="btn blue pull-right" onclick="loginCheck();">
                            Login <i class="m-icon-swapright m-icon-white"></i>
                        </button>            
                    </div>
                    <div class="forget-password">
                        <h4>Forgot your password ?</h4>
                        <p>
                            no worries, click <a href="javascript:;" class="" id="forget-password">here</a>
                            to reset your password.
                        </p>
                    </div>
                    <div class="create-account">
                        <p>
                            Don't have an account yet ?&nbsp; 
                            <a href="javascript:;" id="register-btn" class="">Create an account</a>
                        </p>
                    </div>
            </form:form>
            <!-- END LOGIN FORM -->        
            <!-- BEGIN FORGOT PASSWORD FORM -->
            <form:form class="form-vertical forget-form" action="#">
                <h3 class="">Forget Password ?</h3>
                <p>Enter your e-mail address below to reset your password.</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-envelope"></i>
                            <input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <button type="button" id="back-btn" class="btn">
                        <i class="m-icon-swapleft"></i> Back
                    </button>
                    <button type="submit" class="btn blue pull-right">
                        Submit <i class="m-icon-swapright m-icon-white"></i>
                    </button>            
                </div>
            </form:form>
            <!-- END FORGOT PASSWORD FORM -->
            <!-- BEGIN REGISTRATION FORM -->
            <form:form class="form-vertical register-form" action="#">
                <h3 class="">Sign Up</h3>
                <p>Enter your account details below:</p>
                <div class="control-group">
                    <label class="control-label visible-ie8 visible-ie9">Username</label>
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-user"></i>
                            <input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label visible-ie8 visible-ie9">Password</label>
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-lock"></i>
                            <input class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password" name="password"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-ok"></i>
                            <input class="m-wrap placeholder-no-fix" type="password" placeholder="Re-type Your Password" name="rpassword"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Email</label>
                    <div class="controls">
                        <div class="input-icon left">
                            <i class="icon-envelope"></i>
                            <input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox">
                            <input type="checkbox" name="tnc"/> I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>
                        </label>  
                        <div id="register_tnc_error"></div>
                    </div>
                </div>
                <div class="form-actions">
                    <button id="register-back-btn" type="button" class="btn">
                        <i class="m-icon-swapleft"></i>  Back
                    </button>
                    <button type="submit" id="register-submit-btn" class="btn blue pull-right">
                        Sign Up <i class="m-icon-swapright m-icon-white"></i>
                    </button>            
                </div>
            </form:form>
            <!-- END REGISTRATION FORM -->
        </div>
        <!-- END LOGIN -->
        <!-- BEGIN COPYRIGHT -->
        <div class="copyright">
            2013 &copy; Metronic - Admin Dashboard Template.
        </div>


        <!-- END COPYRIGHT -->
        <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- BEGIN CORE PLUGINS -->
        <script src="assets/plugins/jquery-1.10.1.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
        <script src="assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <!--[if lt IE 9]>
        <script src="assets/plugins/excanvas.min.js"></script>
        <script src="assets/plugins/respond.min.js"></script>  
        <![endif]-->   
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
        <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script src="assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <script src="assets/scripts/login-soft.js" type="text/javascript"></script>      
        <!-- END PAGE LEVEL SCRIPTS --> 

        <!-- Noty Scripts -->

        <script src="assets/notyPlugin/jquery.noty.js" type="text/javascript" ></script>
        <script src="assets/notyPlugin/top.js" type="text/javascript" ></script>
        <script src="assets/notyPlugin/default.js" type="text/javascript" ></script>


        <!-- Noty Scripts -->


        <script>
    jQuery(document).ready(function() {
        App.init();
        Login.init();

    });
        </script>

        <script>
            $(document).ready(function() {
                $("#loginClick").click(function() {
                    loginCheck();
                })
            });

            function loginCheck() {
                if ($('#username').val().length === 0 && $('#password').val().length === 0) {
                    generateNoty('top', 800, 'error', "UserName and password can not be blank");
                }
                else if ($('#password').val().length === 0) {
                    generateNoty('top', 800, 'error', "password can not be blank");
                }
                else if ($('#username').val().length === 0) {
                    generateNoty('top', 800, 'error', "UserName can not be blank");
                }
                else {
//                    var form = document.getElementsById("form-login");
                    var form = document.getElementById("form-login");
                    form.submit();
//                    jQuery.ajax({
//                        url: 'home.htm',
//                        method: 'post',
//                        data: $('#form-login').serialize()
//                    }).done(function(response) {
//                        if (response === "success") {
//                            
//                            window.location.href = 'clerk/home';
////                                $("#form-login").ajaxSubmit({url: 'home.do', type: 'post'})
////                                $.post('home.do', $('#form-login').serialize())
//                            //                            sendIt();
////                                generateNoty('top', 600, 'success', response);
//                        }
//
//                        else {
//                            generateNoty('top', 800, 'error', "auhtentication failed.");
//                        }
//                        // Do something with the response
//                    }).fail(function() {
//                        generateNoty('top', 1000, 'error', "something is wrong..");
//                    });

                }

            }

            function generateNoty(layout, timeout, type, response) {
                var n = noty({
                    layout: layout,
                    type: type,
                    text: response, // can be html or string
//                    dismissQueue: false, // If you want to use queue feature set this true
//                    template: '<div class="noty_message"><span class="noty_text"></span><div class="noty_close"></div></div>',
//                    animation: {
//                        open: {height: 'toggle'},
//                        close: {height: 'toggle'},
//                        easing: 'swing',
//                        speed: 500 // opening & closing animation speed
//                    },
                    timeout: timeout // delay for closing event. Set false for sticky notifications
//                    force: false, // adds notification to the beginning of queue when set to true
//                    modal: false,
//                    maxVisible: 5, // you can set max visible notification for dismissQueue true option,
//                    killer: false, // for close all notifications before show
//                    closeWith: ['hover'], // ['click', 'button', 'hover']
//                    callback: {
//                        onShow: function() {
//                        },
//                        afterShow: function() {
//                        },
//                        onClose: function() {
//                        },
//                        afterClose: function() {
//                        }
//                    },
//                    buttons: false // an array of buttons
                });
            }

        </script>

        <!-- END JAVASCRIPTS -->
    </body>
    <!-- END BODY -->
</html>